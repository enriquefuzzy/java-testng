# java-testng

Automation framework using Cucumber with Selenium and TestNG.

Created in IntelliJ

## Requirements

- Java 18
- Maven 3.8.5
- Chromedriver

### pom.xml

Dependencies (see `pom.xml` for versions):
- selenium-java
- testng
- cucumber-core
- cucumber-html
- cucumber-java
- cucumber-testng
- cucumber-jvm-deps
- hamcrest-core
- gherkin
- slf4j-api
- slf4j-simple

Plugins:
- maven-compiler-plugin
- maven-surefire-plugin

Install dependencies from pom.xml with `mvn clean install`

Refresh the project every time the pom.xml is updated by right-clicking the source folder and selecting `Maven > Reload Project`

## Executing tests

Execute tests with `mvn clean test`