plugins {
    java
}

tasks {
  create<Jar>("graderJar") {
    group = "build"
    afterEvaluate {
      archiveFileName.set("FOP-2022-H04-${project.version}.jar")
      from(project(":grader").sourceSets.main.get().allSource)
      from(project(":solution").sourceSets.main.get().allSource)
    }
  }
}

allprojects {
    apply(plugin = "java")
    version = "1.0.0-SNAPSHOT"
  repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
    dependencies {
        // FOPBot available in all source sets
        implementation("org.sourcegrade:fopbot:0.3.0")
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
