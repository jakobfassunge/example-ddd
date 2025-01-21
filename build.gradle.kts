plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "6.23.0" // Add the Spotless plugin
}

group = "com.esentri.ddd"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.domainlifecycles:spring-boot-3-jooq-complete:2.0.1")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    java {
        // You can define your preferred style here, e.g., Google's Java Style
        googleJavaFormat()
        // If you have specific customizations, you can chain them with additional settings.
        // For example, you might add a license header or tweak import ordering.
        
        // licenseHeaderFile("path/to/licenseHeader") // Uncomment and set path if you have a license header
    }
}
