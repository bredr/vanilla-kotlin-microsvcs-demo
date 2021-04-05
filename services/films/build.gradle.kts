plugins {
  id("org.jetbrains.kotlin.jvm")
  application
  id("com.google.cloud.tools.jib") version "2.8.0"
}

version = "0.1.0"
group = "services.films"

repositories {
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${rootProject.ext["kotlinVersion"]}")
  implementation("org.jetbrains.kotlin:kotlin-reflect:${rootProject.ext["kotlinVersion"]}")
  implementation(project(":protos"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["kotlinxCoroutinesVersion"]}")
  runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")
  implementation("io.grpc:grpc-kotlin-stub:${rootProject.ext["grpcKotlinVersion"]}")
  runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
}

java {
  sourceCompatibility = JavaVersion.toVersion("1.8")
}

application {
  mainClass.set("demo.films.FilmsServerKt")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "1.8"
    }
  }
  compileTestKotlin {
    kotlinOptions {
      jvmTarget = "1.8"
    }
  }
}
