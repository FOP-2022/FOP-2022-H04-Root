repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    mavenLocal()
}

dependencies {
    implementation(project(":solution"))
    compileOnly("org.sourcegrade:jagr-grader-api:0.3-SNAPSHOT")
    implementation("fr.inria.gforge.spoon:spoon-core:10.0.0")
    compileOnly("org.sourcegrade:docwatcher-api:0.1.0-SNAPSHOT")
}
