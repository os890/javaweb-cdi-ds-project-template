# JavaWeb CDI DeltaSpike Project Template

A minimal Java web application template demonstrating **JSF**, **CDI** (OpenWebBeans), and **Apache DeltaSpike** working together.

## Architecture

- **GreetingService** — `@ApplicationScoped` CDI bean that produces greeting messages.
- **HelloWorldController** — `@WindowScoped` JSF backing bean (DeltaSpike) that captures user input and delegates to the greeting service.
- **JSF pages** — `helloWorld.xhtml` (input form) and `result.xhtml` (greeting output).

## Requirements

- **Java 25+**
- **Maven 3.6.3+**

## JSF Profiles

| Profile   | Default | JSF Implementation       | Activate        |
|-----------|---------|--------------------------|-----------------|
| `myfaces` | yes     | Apache MyFaces 4.1       | (active by default) |
| `mojarra` | no      | Eclipse Mojarra (Faces) 4.0 | `-Pmojarra`   |

## Build

```bash
# Default build (MyFaces profile + CDI tests)
mvn clean verify

# Mojarra profile
mvn clean verify -Pmojarra,cdi
```

## Run with Jetty

```bash
mvn jetty:run
```

Then open <http://localhost:8080/javaweb-cdi-ds-project-template/helloWorld.xhtml>.

## Quality Plugins

| Plugin       | Purpose                              |
|--------------|--------------------------------------|
| Compiler     | `-Xlint:all`, fail on warnings       |
| Enforcer     | Java 25+, Maven 3.6.3+, dependency convergence, ban javax.* |
| Checkstyle   | Code style enforcement (see `checkstyle.xml`) |
| RAT          | Apache 2.0 license header verification |
| Surefire     | Test execution                       |
| JaCoCo       | Code coverage reporting              |
| Javadoc      | API documentation generation         |

## Testing

CDI SE tests use the [Dynamic CDI Test Bean Addon](https://github.com/os890/dynamic-cdi-test-bean-addon)
with `@EnableTestBeans` for lightweight container bootstrap and automatic bean discovery.

## License

This project is licensed under the [Apache License, Version 2.0](LICENSE).
