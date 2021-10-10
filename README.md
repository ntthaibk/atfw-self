[![badge-jdk](https://img.shields.io/badge/jdk-11-green.svg)](https://www.oracle.com/java/technologies/javase-downloads.html)

# Aspire Challenge Web Automation Framework

- [Aspire Challenge Web Automation Framework](#aspire-challenge-web-automation-framework)
  - [Motivation](#motivation)
  - [Features:](#features)
  - [Getting Started](#getting-started)
    - [1. Installation](#1-installation)
    - [2. Dependencies Requirements](#2-dependencies-requirements)
    - [3. Test Execution](#3-test-execution)
      - [3.1. Run the TestNG instance:](#31-run-the-testng-instance)
      - [3.2. Run the Maven test command:](#32-run-the-maven-test-command)
    - [4. Test Creation:](#4-test-creation)
  - [Aspire Challenge](#aspire-challenge)
    - [Test Case](#test-case)


## Motivation

A test framework dedicated for the Aspire Challenge Test to implement automation test for the Aspire Demo App.

## Features:
- Web testing with Selenium + TestNG
- Browser supported: Chrome, FireFox
- TBD

## Getting Started

### 1. Installation

- Clone this repository directly from Github

### 2. Dependencies Requirements

- **JDK Version**: 11, you can download either from
  here [JDK11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and setting up the JAVA_HOME
  environment variable. For more information, please look at
  this [Instruction](https://mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/).
  **Please don't attempt to upgrade or downgrade the JDK to 8 or higher version**  
  &nbsp;
- **IDE**: Please use your Java IDE that you feel familiar with, e.g: Eclipse, IntelliJ, NetBeans,...
- **Maven**: Build Tool for this Framework.
- **Lombok**: This is the Library for Trimming down the redundancy of POJO classes which will make the framework look
  repetitive in the long run. For more information, please go to this Link for more details
  on [Project Lombok](https://projectlombok.org/).


### 3. Test Execution

  #### 3.1. Run the TestNG instance:

  You can run the testNG instance in the Test code directly by simply run the suite in test package.

  - Here is the sample code:

```java
@Listeners(TestListener.class)
        public class DriverManagerTest extends ServiceInjection {
            @Test
            public void initDriverBasedOnBrowserName() {
                String browserName = "chrome";
                WebDriver driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
                DriverManager.setDriver(driver);
                Injector injector = Guice.createInjector(new WebDriverModule());
                loginPage = injector.getInstance(LoginPage.class);
                driver.get("https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/login");
                loginPage.verifyLoginLabelDisplayedCorrectly();
            }
        }

```

#### 3.2. Run the Maven test command:

- Initiate the test through the command like this

    ```shell
    mvn clean test [suiteName] -D[params...]
    ```

- where:
      - **suiteName**: by default I created the suite name `suite.xml`, you can go create another one based on your need of test run
      - **parameters**: by now I implemented 2 parameters `browserName` for choosing the Browser at runtime and `defaultTimeOut` for default web wait time out.

### 4. Test Creation:
- We structured the test FW in ehanced Page Object Model (More about it here [Enhanced-POM](https://www.seleniumeasy.com/selenium-tutorials/page-factory-pattern-in-selenium-webdriver) ) with `PageFactory`.
- Below is step-by-step test case creation:
    - Extend from BasePage (Since we will store our test object and page action in the **Pages**). e.g, I have a Login Page, so just need to follow the code implemented below for creating a new Page
    
    ```java
    public class LoginPage extends BasePage {

    @FindBy(xpath = "xpath")
    private WebElement loginLabel;

    // adding test object here

    @Inject
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doSomethingWithLogin(){
        //do it here
    }

    ```
    - Adding test object and method and you are good to go


## Aspire Challenge

### Test Case
|Steps   | Action  | Expected|
|---|---|---|
|   |   |   |
