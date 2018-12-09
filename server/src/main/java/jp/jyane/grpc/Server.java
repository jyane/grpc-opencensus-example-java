package jp.jyane.grpc;

import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.opencensus.contrib.grpc.metrics.RpcViews;
import io.opencensus.exporter.stats.prometheus.PrometheusStatsCollector;
import io.prometheus.client.exporter.HTTPServer;
import java.io.IOException;
import java.util.logging.Logger;

public class Server {
  private final static Logger logger = Logger.getLogger(Server.class.getName());
  private final static int PORT = 10080;

  private io.grpc.Server grpcServer;
  private HTTPServer prometheusServer;

  private void start() throws IOException {
    RpcViews.registerServerGrpcViews();
    PrometheusStatsCollector.createAndRegister();
    grpcServer = ServerBuilder.forPort(PORT)
        .addService(new TestServiceImpl())
        .addService(ProtoReflectionService.newInstance())
        .build()
        .start();
    prometheusServer = new HTTPServer(PORT + 1, true);
    logger.info("GrpcServer start at port: " + PORT);
    logger.info("PrometheusServer start at port: " + (PORT + 1));
    Runtime.getRuntime().addShutdownHook(new Thread(Server.this::stop));
  }

  private void stop() {
    if (prometheusServer != null) {
      prometheusServer.stop();
    }
    if (grpcServer != null) {
      grpcServer.shutdown();
    }
  }

  private void await() throws InterruptedException {
    if (grpcServer != null) {
      grpcServer.awaitTermination();
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = new Server();
    server.start();
    server.await();
  }
}
