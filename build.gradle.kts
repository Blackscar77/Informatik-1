plugins {
    java
    application
}

group = "org.example"
version = "1.0"


val groupID = project.group.toString()
val artifactID = project.name.lowercase()
val projektVersion = project.version.toString()
val projektName = project.name.toString()

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    enableAssertions = true
}

//Für die .jar datei
tasks.jar {
    manifest.attributes["Main-Class"] = "$groupID.Run"
    archiveFileName.set("app.jar")
}

tasks.compileJava {
    options.release.set(25)
    options.encoding = "UTF-8"
}

tasks.run {
    mainClass.set("$groupID.Run")
    enableAssertions = true
    standardInput = System.`in`
    jvmArgs("-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8")
}