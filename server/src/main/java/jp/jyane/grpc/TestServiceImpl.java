package jp.jyane.grpc;

import io.grpc.stub.StreamObserver;
import jyane.grpc.Test.SimpleRequest;
import jyane.grpc.Test.SimpleResponse;
import jyane.grpc.TestServiceGrpc;

public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

  @Override
  public void unaryCall(SimpleRequest request, StreamObserver<SimpleResponse> responseObserver) {
    SimpleResponse response = SimpleResponse.newBuilder()
        .setStr(request.getStr())
        .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
