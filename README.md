# Vaadin todo app with TypeScript views

A sample app that uses Vaadin's new type-safe communication between a Spring Boot backend and a LitElement + TypeScript frontend.

Try adding a field in the `Todo.java` file, and notice how it becomes available in the TypeScript API automatically.

## Requirements

- Java 11

## Running

```
mvn spring-boot:run
```

Frontend changes are picked up directly. Backend changes need to be built, your IDE may do this automatically on save.

## Project structure

Frontend files are in `./frontend`
Backend files are in `./src/main/java/com/example/application`
