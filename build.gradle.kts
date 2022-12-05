import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.7.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
	implementation("org.springframework.batch:spring-batch-core:4.3.3")

	implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")

	implementation("com.microsoft.sqlserver:mssql-jdbc")
	runtimeOnly("com.h2database:h2:1.4.197")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
