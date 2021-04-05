plugins {
   id("org.jetbrains.kotlin.jvm") version "1.4.10" apply false
  id("com.google.protobuf") version "0.8.13" apply false
}

ext["grpcVersion"] = "1.32.1"
ext["grpcKotlinVersion"] = "1.0.0" // CURRENT_GRPC_KOTLIN_VERSION
ext["protobufVersion"] = "3.13.0"
ext["kotlinVersion"] = "1.4.10"
ext["kotlinxCoroutinesVersion"] = "1.3.3"

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    google()
  }

  apply(plugin = "org.jetbrains.kotlin.jvm")
}
