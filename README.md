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

Default cucumber feature location and stepDefinition location are set in CucumberRunnerTests.java.
Cucumber tags can be overridden by being included in the `mvn test` command.

Right click inside CucumberRunnerTests.java and select `Run 'CucumberRunnerTests'` to execute tests as defined in CucumberRunnerTests.java

Uncomment `maven-surefire-plugin` configuration in `pom.xml` to force Cucumber options from `testng.xml`

### MVN Execution Commands

Execute default tests with `mvn clean test`

Execute specific tests via cucumber tag with `mvn clean test -Dcucumber.filter.tags="@regression"`
