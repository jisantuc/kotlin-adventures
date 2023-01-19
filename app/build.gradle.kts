plugins {
    id("application")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

application {
    mainClass.set("adventures.Main")
}

dependencies {
  implementation(project(":lib"))
}

