import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    application
    kotlin("jvm") version "1.2.41"
}

application {
    mainClassName = "samples.HelloCoroutinesKt"
}

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

