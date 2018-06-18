import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.types.checker.captureFromArguments
import java.net.URL

plugins {
    kotlin("jvm") version "1.2.41"
    maven
    jacoco
    id("org.jetbrains.dokka") version "0.9.17"
}

group = "io.tafel"
version = "0.1.0"
description = "Hirez sdk in kotlin using coroutines"

kotlin { // configure<org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension>
    experimental.coroutines = Coroutines.ENABLE
}

dependencies {
    compile(kotlin("stdlib"))
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.23.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor
    compile("com.squareup.okhttp3", "logging-interceptor", "3.10.0")


    testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testCompile("org.mockito:mockito-core:2.10.0")
    testCompile("com.squareup.retrofit2:retrofit-mock:2.3.0")
}

repositories {
    jcenter()
}

/* Code coverage */

val jacocoTestReport by tasks.getting(JacocoReport::class) {
    reports.xml.isEnabled = true
}

val test by tasks.getting {
    finalizedBy(jacocoTestReport)
}

/* KDoc */

val dokka by tasks.getting(DokkaTask::class) {
    outputFormat = "javadoc"
    outputDirectory = "$buildDir/javadoc"

    externalDocumentationLink(delegateClosureOf<DokkaConfiguration.ExternalDocumentationLink.Builder> {
        url = URL("https://square.github.io/okhttp/3.x/okhttp/")
    })
    externalDocumentationLink(delegateClosureOf<DokkaConfiguration.ExternalDocumentationLink.Builder> {
        url = URL("https://square.github.io/retrofit/2.x/retrofit/")
    })
}

val sourcesJar by tasks.creating(Jar::class) {
    dependsOn("classes")
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

val javadocJar by tasks.creating(Jar::class) {
    dependsOn(dokka)
    classifier = "javadoc"
    from("$buildDir/javadoc")
}

artifacts {
    add("archives", javadocJar)
    add("archives", sourcesJar)
}
