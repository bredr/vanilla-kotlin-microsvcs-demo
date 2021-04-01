rootProject.name = "demo"

include("protos")

File("services").walk()
    .filter { it -> it.isDirectory && it.listFiles().map { x -> x.name }.contains("build.gradle.kts") }
    .forEach {
        include(it.name)
        project(":${it.name}").projectDir  = it
    }