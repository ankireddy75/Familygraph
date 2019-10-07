plugins {
    kotlin("jvm") version "1.3.21"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("org.springframework.boot") version "2.1.8.RELEASE"
    java
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile( kotlin("stdlib") )
    compile("com.google.guava:guava:18.0")
    compile( "org.apache.commons:commons-lang3:3.3.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testCompile("junit:junit:4.+")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    testLogging {
        events("PASSED", "FAILED", "SKIPPED", "STANDARD_ERROR", "STANDARD_OUT")
    }
}