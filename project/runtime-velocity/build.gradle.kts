import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
    compileOnly(project(":project:common"))
//    compileOnly(project(":project:module-chat"))
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjvm-default=all", "-Xextended-compiler-checks")
    }
}

taboolib { subproject = true }