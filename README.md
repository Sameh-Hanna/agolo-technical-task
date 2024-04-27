# Agolo Technical Task

## Project Overview
This project contains the implementation for Agolo technical task as below:
### Q1 Part1 Pet Store API Tests
implemented in src\test\java\Q01_Part01_PetStore\PetStoreAPITests.java

### Q1 Part2 Demoblaze Login and Sign Up Tests
implemented in:
- src\test\java\Q01_Part02_Demoblaze\LoginTests
- src\test\java\Q01_Part02_Demoblaze\SignUpTests.java

### Q2 Part1 Xml Deserializer
implemented in src\test\java\Q02_Part01_XmlDeserialiser\websitesXmlDeserializer.java

### Q2 Part2 STC TV Subscription Packages
implemented in cypress\e2e\STCTV



## Installation and Setup:
### 1. Clone the repo:
```bash
## clone this repo to a local directory
git clone ```bash

## clone this repo to a local directory
git clone github.com/Sameh-Hanna/agolo-technical-task.git

## cd into the cloned repo
cd agolo-technical-task

## To run Pet Store API, Demoblaze tests:
mvn clean test

## To get the test report:
mvn allure:serve

## To run Xml Deserializer:
javac src\test\java\Q02_Part01_XmlDeserialiser\websitesXmlDeserializer.java

java Q02_Part01_XmlDeserialiser.websitesXmlDeserializer

## To run STC TV Subscription Packages

### install npm packages including Cypress
npm install

### start Cypress 
npx cypress open

### Click on E2E Testing
### Slect Chrome or Edge browser in Cypress runner
### Click on Start E2E Testing button
### Click on CheckSubscriptionPackages test specs
