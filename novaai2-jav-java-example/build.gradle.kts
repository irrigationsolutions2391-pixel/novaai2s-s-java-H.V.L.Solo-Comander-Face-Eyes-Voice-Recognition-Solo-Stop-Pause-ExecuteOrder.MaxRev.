plugins {
    id("novaai2-jav.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":novaai2-jav-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :novaai2-jav-java-example:run` to run `Main`
    // Use `./gradlew :novaai2-jav-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.configure_me_novaai2_jav.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
