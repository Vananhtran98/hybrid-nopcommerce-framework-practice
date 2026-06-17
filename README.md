# Hybrid Automation Framework for nopCommerce

## Project Overview

This is a personal QA Automation project built to practice designing a scalable and maintainable Hybrid Automation Framework for the nopCommerce e-commerce application.

The project demonstrates how to apply Page Object Model (POM), reusable utilities, reporting, and test data management to automate end-to-end business scenarios.

## Objectives

- Build a maintainable Hybrid Automation Framework from scratch.
- Apply Page Object Model (POM) design pattern.
- Implement reusable utilities and common functions.
- Organize test data and test execution configurations.
- Generate test execution reports.
- Practice real-world automation workflows.

## Tech Stack

- Language: Java
- Automation Tool: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- Design Pattern: Page Object Model (POM)
- Reporting: Extent Report
- Logging: Log4j
- Version Control: Git/GitHub

## Project Structure

```text
src/main/java
├── commons
├── pageObjects
├── pageUIs
└── reportConfig

src/test/java
├── testcases
└── listeners

testdata
reports
```

## Automated Test Scenarios

- User Registration
- User Login
- Search Product
- Product Review
- Add Product to Wishlist
- Add Product to Compare List
- Shopping Cart
- Checkout Flow
- My Account Management

## Key Highlights

- Designed a Hybrid Automation Framework following Page Object Model.
- Implemented reusable methods to reduce duplicated code.
- Separated test data, locators, and business logic for easier maintenance.
- Generated execution reports for better test result tracking.
- Organized test cases to support scalable automation development.

## How to Run

1. Clone repository

```bash
git clone <repository_url>
```

2. Install dependencies

```bash
mvn clean install
```

3. Execute test suite

```bash
mvn test
```

## Learning Outcome

This project was created to strengthen my QA Automation skills and gain hands-on experience in building a maintainable automation framework using Java, Selenium, and TestNG.
