package demo.films

import films.app.FilmServiceGrpcKt
import io.grpc.Server
import io.grpc.ServerBuilder

class FilmsServer(private val port: Int) {
  private val server: Server = ServerBuilder
    .forPort(port)
    .addService(FilmsService())
    .build()
  fun start() {
    server.start()
    println("server started, listening on $port")
    Runtime.getRuntime().addShutdownHook(
      Thread {
        println("*** shutting down gRPC server since JVM is shutting down")
        this@FilmsServer.stop()
        println("*** server shut down")
      }
    )
  }
  private fun stop() {
    server.shutdown()
  }

  fun blockUntilShutdown() {
    server.awaitTermination()
  }

  private class FilmsService : FilmServiceGrpcKt.FilmServiceCoroutineImplBase()
}

fun main() {
  val port = System.getenv("PORT")?.toInt() ?: 50051
  val server = FilmsServer(port)
  server.start()
  server.blockUntilShutdown()
}
