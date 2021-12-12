repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(project(":solution"))
    implementation("org.sourcegrade:jagr-grader-api:0.3-SNAPSHOT")
}
