#  Login Performance Automation Framework

Selenium + Cucumber based automation framework validating UI and API login performance with response-time threshold checks.

---

##  Overview

This project automates login validation by combining:

- UI Automation (Selenium WebDriver)
- API Validation
- Performance threshold validation
- BDD structure using Cucumber
- Page Object Model (POM) architecture

The framework validates both functional correctness and response time performance.

---

##  Architecture
```bash
login-performance-automation-framework
└── src
    └── test
        ├── java
        │   ├── api
        │   ├── hooks
        │   ├── pages
        │   ├── runners
        │   ├── stepdefinitions
        │   └── utils
        └── resources
            ├── config
            └── features
```

### Key Components

- **POM design pattern**
- **PerformanceContext utility** for scenario duration tracking
- **Parallel & headless execution**
- **Config-driven setup**
- **CI-ready structure**

---

##  Tech Stack

- Java
- Selenium
- Cucumber (BDD)
- WebDriverManager
- Maven

---

##  What Is Validated

- Login UI response time under defined threshold
- Login API response time validation
- Scenario total duration tracking
- Combined UI + API execution flow

Example output:
UI login duration: 515 ms
Scenario total duration: 1608 ms

---

## How to Run

```bash
mvn clean test

