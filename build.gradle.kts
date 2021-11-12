plugins {
  java
}
allprojects {
  apply(plugin = "java")
  repositories {
    mavenCentral()
  }
  dependencies {
    // FOPBot available in all source sets
    implementation("org.sourcegrade:fopbot:0.2.0")
    // JUnit only available in "test" source set (./src/test)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
  }
  java {
    withSourcesJar()
  }
  tasks {
    jar {
      archiveFileName.set("${rootProject.name}-${project.name}.jar")
    }
    named<Jar>("sourcesJar") {
      archiveFileName.set("${rootProject.name}-${project.name}-sources.jar")
    }
  }
}
