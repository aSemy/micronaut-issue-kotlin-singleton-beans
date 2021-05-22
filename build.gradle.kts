plugins {
  val kotlinVersion = "1.5.0"
  id("org.jetbrains.kotlin.jvm") version kotlinVersion
  id("org.jetbrains.kotlin.kapt") version kotlinVersion
  id("com.github.johnrengelman.shadow") version "7.0.0"
  id("io.micronaut.application") version "1.5.0"
  id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
}

version = "0.1"
group = "com.example"

repositories {
  mavenCentral()
}

micronaut {
  runtime("netty")
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.example.*")
  }
}

dependencies {
  val kotlinVersion = "1.5.0"
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-runtime")
  implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
  implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
  implementation("javax.annotation:javax.annotation-api")

  implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
  implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
  runtimeOnly("ch.qos.logback:logback-classic")
  implementation("io.micronaut:micronaut-validation")

  runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

  kapt("io.micronaut:micronaut-inject-java")
  kaptTest("io.micronaut:micronaut-inject-java")
}


application {
  mainClass.set("com.example.ApplicationKt")
}
java {
  sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "11"
    }
  }
  compileTestKotlin {
    kotlinOptions {
      jvmTarget = "11"
    }
  }

}

tasks.named<Wrapper>("wrapper") {
  gradleVersion = "7.0.2"
  distributionType = Wrapper.DistributionType.ALL
}
