# Vaadin todo app with TypeScript views

This is an example app for comparing popular frontend frameworks. You can find the same app implemented in React, Angular, Vaadin TypeScript, and Vaadin Java. The projects can be run in the browser with the GitPod button below.

This app uses Vaadin's new type-safe communication between a Spring Boot backend and a LitElement + TypeScript frontend.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/marcushellberg/vaadin-typescript-todo)


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

## Alternate implementations

- [React todo](https://github.com/marcushellberg/react-todo)
- [Angular todo](https://github.com/marcushellberg/angular-todo)
- [Vaadin TypeScript todo](https://github.com/marcushellberg/vaadin-typescript-todo)
- [Vaadin Java Todo](https://github.com/marcushellberg/vadin-java-todo)
- [Todo REST API](https://github.com/marcushellberg/todo-api)
