plugins {
    application
    kotlin("jvm") version "1.9.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

val gdxVersion = "1.12.0"
//val roboVMVersion = "2.3.16"
val box2DLightsVersion = "1.5"
val aiVersion = "1.8.2"
//val gdxControllersVersion = "2.2.1"


shadow{
}

application {
    mainClass.set("com.mygdx.game.DesktopLauncherKt")
}

tasks.shadowJar {
    minimize()
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/releases/")
    maven("https://jitpack.io")
    google()
}
dependencies {
    //api("io.github.libktx:ktx-math:1.9.11-b1")
    api("com.badlogicgames.gdx:gdx:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.gdx:gdx-box2d:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.box2dlights:box2dlights:$box2DLightsVersion")
    api("com.badlogicgames.gdx:gdx-bullet:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-bullet-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.gdx:gdx-ai:$aiVersion")

    //api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    //testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.0")
    testImplementation(kotlin("test"))
}

tasks.compileKotlin {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
tasks.test {
    useJUnitPlatform()
}