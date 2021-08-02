<!--suppress HtmlDeprecatedAttribute -->
<br/>

<div align="center">
	<img height="200" src="https://raw.githubusercontent.com/PokeAPI/media/master/logo/pokeapi.svg?sanitize=true" alt="PokeAPI">
    <h1>PokéFuture</h1>
    <p>
        A reactive <a href="https://pokeapi.co/">PokéApi-Wrapper</a> written in Java using <a href="https://vertx.io/">Vert.x</a>
    </p>
</div>



# Download
[![Maven Central](https://img.shields.io/maven-central/v/io.github.pascalklassen/poke-future.svg?label=Maven%20Central)](https://search.maven.org/search?q=io.github.pascalklassen.poke-future)

Replace `VERSION` in the examples below with the latest stable release version.

## Maven
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <repositories>
        <repositories>
            <repository>
                <id>ossrh</id>
                <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
            </repository>
        </repositories>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>io.github.pascalklassen</groupId>
            <artifactId>poke-future</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependencies>
</project>
```

## Gradle Groovy DSL
```groovy
repositories {
    maven {
        name 'ossrh'
        url 'https://s01.oss.sonatype.org/content/repositories/snapshots'
    }
}

dependencies {
    implementation 'io.github.pascalklassen:poke-future:VERSION'
}
```

## Gradle Kotlin DSL
```kotlin
repositories {
    maven {
        name = "ossrh"
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation("io.github.pascalklassen:poke-future:VERSION")
}
```

# Getting Started


