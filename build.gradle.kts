plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()


}

dependencies {
    // https://mvnrepository.com/artifact/javax.xml.parsers/jaxp-api
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    implementation("com.sun.xml.bind:jaxb-impl:4.0.3")
// https://mvnrepository.com/artifact/org.apache.commons/commons-csv
    implementation("org.apache.commons:commons-csv:1.10.0")

    implementation("com.theoryinpractise:halbuilder-xml:4.1.3")

    testImplementation("junit:junit:4.13.1")

    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

}


tasks.test {
    useJUnitPlatform()
}