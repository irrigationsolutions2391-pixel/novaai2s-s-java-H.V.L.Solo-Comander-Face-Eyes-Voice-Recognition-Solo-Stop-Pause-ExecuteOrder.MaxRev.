plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("OpenAPI 3.0 Pet Store")
                description.set("This is a sample Pet Store Server based on the OpenAPI 3.0 specification.")
                url.set("https://www.github.com/irrigationsolutions2391-pixel/novaai2s-s-java-H.V.L.Solo-Comander-Face-Eyes-Voice-Recognition-Solo-Stop-Pause-ExecuteOrder.MaxRev.")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Novaai2 Jav")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/irrigationsolutions2391-pixel/novaai2s-s-java-H.V.L.Solo-Comander-Face-Eyes-Voice-Recognition-Solo-Stop-Pause-ExecuteOrder.MaxRev..git")
                    developerConnection.set("scm:git:git://github.com/irrigationsolutions2391-pixel/novaai2s-s-java-H.V.L.Solo-Comander-Face-Eyes-Voice-Recognition-Solo-Stop-Pause-ExecuteOrder.MaxRev..git")
                    url.set("https://github.com/irrigationsolutions2391-pixel/novaai2s-s-java-H.V.L.Solo-Comander-Face-Eyes-Voice-Recognition-Solo-Stop-Pause-ExecuteOrder.MaxRev.")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
    repositories {
        if (project.hasProperty("publishLocal")) {
            maven {
                name = "LocalFileSystem"
                url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
