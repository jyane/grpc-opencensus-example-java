java_library(
    name = "opencensus_example",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        "@io_grpc_grpc_java//core",
        "@io_grpc_grpc_java//netty",
        "@io_grpc_grpc_java//stub",
        "@io_grpc_grpc_services//jar",
        "@io_opencensus_opencensus_api//jar",
        "@io_opencensus_opencensus_contrib_grpc_metrics//jar",
        "@io_opencensus_opencensus_exporter_stats_prometheus//jar",
        "@io_prometheus_simpleclient//jar",
        "@io_prometheus_simpleclient_common//jar",
        "@io_prometheus_simpleclient_httpserver//jar",
        "//proto:test_java_grpc",
        "//proto:test_java_proto",
    ],
)

java_binary(
    name = "opencensus_example_server",
    main_class = "jp.jyane.grpc.Server",
    runtime_deps = [":opencensus_example"],
)