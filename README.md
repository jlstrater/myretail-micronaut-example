# myretail-micronaut-example

The myRetail Micronaut Example application is a simple microservice that aggregates product data from multiple data sources and provides an endpoint for simple GET requests: `/products/{id}`.

---

## Requirements
* Java 9-12

The myRetail example application is built using gradle. The following are standard commands for Gradle.

## Running checks locally

To ensure that all checks are passing, execute:

`./gradlew check` 

This command will run the tests and any other checks like any code coverage and static analysis tools as you would want to do before pushing to a remote repository.

## Building the app

To run a full build including compilation, any checks (tests, static analysis, code coverage, etc), and creation of a jar, execute the command:

`./gradlew build`

## Running the app

To run the app, execute the command

`./gradlew run`

## Debugging build issues

Included in the build config is a plugin that generates a report called a build scan which is useful for debugging build issues including compilation errors, dependency conflicts, and more. The url for that report is at the end of the build output.

![Build Scan Example](images/build-scan-example.png)

---
\* on windows, use `gradlew` instead of `./gradlew`
