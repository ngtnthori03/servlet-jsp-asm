plugins {
    id("java")
    war
    id("org.gretty") version "4.1.1"
}

apply(plugin = "org.gretty")

group = "tigi.servlet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")
    compileOnly ("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")

    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.0")

    implementation("com.microsoft.sqlserver:mssql-jdbc:11.2.3.jre17")
    implementation("org.hibernate.orm:hibernate-core:6.4.0.Final")

    implementation("commons-beanutils:commons-beanutils:1.9.4")


}

tasks.test {
    useJUnitPlatform()
}
// http://localhost:8080/'contextPath'/
gretty {
    contextPath = "tigi"
}
