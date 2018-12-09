workspace(name = "grpc_opencensus_example_java")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "io_grpc_grpc_java",
    strip_prefix = "grpc-java-1.17.1",
    urls = ["https://github.com/grpc/grpc-java/archive/v1.17.1.zip"],
)

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")
grpc_java_repositories()

maven_jar(
    name = "io_opencensus_opencensus_exporter_stats_prometheus",
    artifact = "io.opencensus:opencensus-exporter-stats-prometheus:0.17.0",
)

maven_jar(
    name = "io_prometheus_simpleclient",
    artifact = "io.prometheus:simpleclient:0.6.0",
)

maven_jar(
    name = "io_prometheus_simpleclient_httpserver",
    artifact = "io.prometheus:simpleclient_httpserver:0.6.0",
)

maven_jar(
    name = "io_prometheus_simpleclient_common",
    artifact = "io.prometheus:simpleclient_common:0.6.0",
)

maven_jar(
    name = "io_grpc_grpc_services",
    artifact = "io.grpc:grpc-services:1.17.1",
)
