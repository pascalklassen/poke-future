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

## Fetch a single Pokémon

```java
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;

class Example {
    public static void main(String[] args) {
        Pokemon
                .fetch("bulbasaur") // Future<Pokemon>
                .onSuccess(pokemon -> System.out.println(pokemon.getName()))
                .onFailure(cause -> System.err.println(cause.getMessage()));
    }
}
```

## Fetch a List of Pokémon

```java
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.utility.common.APIResource;

class Example {
    public static void main(String[] args) {
        Pokemon
                .fetchList() // Future<NamedAPIResourceList<Pokemon>>
                .compose(resourceList -> APIResource.composeAll(resourceList.getResults())) // Future<List<Pokemon>>
                .onSuccess(pokemonList -> 
                        pokemonList.forEach(pokemon -> System.out.println(pokemon.getName())))
                .onFailure(cause -> System.err.println(cause.getMessage()));
    }
}
```

# How it works

## Model representation

To minimize the effort of learning a new API Structure, our goal was to represent a 1:1 Model
of the official [REST-PokéAPI](https://pokeapi.co/docs/v2). New Users can just look at the
REST Model and immediately understand what methods they need to call on our Objects.

This seems quite handy, but it comes along the way with some code smells that we try to reduce as much
as needed.

For example, the PokéAPI has some [common Models](https://pokeapi.co/docs/v2#common-models) such 
as `APIResource`, `NamedAPIResource`, `APIResourceList` and `NamedAPIResourceList` to reduce the
number of data they need to send per request. The first two `APIResource` and `NamedAPIResource`
both represent a link to a REST-Resource where you can request additional data. To counteract this
drawback, we allow the User to chain their API calls in an asynchronous way with 
[Future Composition](https://dev.to/cherrychain/future-composition-in-vert-x-3gp8).

This will look like this:

```java
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;

class Example {
    public static void main(String[] args) {
        Pokemon
                .fetch("bulbasaur")
                // PokemonSpecies is a NamedAPIResource, so you need to fetch it seperately
                .compose(pokemon -> pokemon.getSpecies().fetch())
                // PokemonColor is a NamedAPIResource, so you need to fetch it seperately
                .compose(species -> species.getColor().fetch())
                .onSuccess(color -> System.out.println("Bulbasaur is " + color.getName()))
                .onFailure(cause -> System.err.println(cause.getMessage()));
    }
}
```

`Pokemon#getSpecies` and `PokemonSpecies#getColor` both return a NamedAPIResource, in fact you can just
see this in the official documentation, on which you can invoke the `APIResource#fetch` Method that returns
a [Future](https://vertx.io/docs/vertx-core/java/#_future_results) Object that provides you the results as
its underlying process is completed.
