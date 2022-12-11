# SpriteCloudDemo
[![Java 17](https://img.shields.io/badge/Java-17-green)](https://www.oracle.com/eg/java/technologies/downloads/#java17) [![Intellij 2022.3](https://img.shields.io/badge/IntelliJ-2022.3-yellow)](https://www.jetbrains.com/idea/download/#section=mac) [![Shaft_Engine 6.4.20221204](https://img.shields.io/badge/SHAFT__Engine-6.4.20221204-blue)](https://github.com/ShaftHQ/SHAFT_ENGINE)

## Task

- [x] Prepare Test cases and scripts to cover important scenarios while testing 'http://www.uitestingplayground.com/home' as a web GUI
- [x] Prepare Test cases and scripts to cover important scenarios while testing the provided endpoints for the APIs listed in 'https://petstore.swagger.io/'

## Covered Scenarios/Modules
### APIs
#### 1. Pet endpoints
`POST /pet`
`GET /pet/findByStatus`
`GET /pet/{petId}`
`DELETE /pet/{petId}`

#### 2. Store endpoints
`POST /store/order`
`GET /store/order/{orderId}`
`DELETE /store/order/{orderId}`

> Reasons: To cover an E2E flow starting from creation, followed by retrieval and deletion of the created entity

### Web GUI
`Sample App page`
`Ajax data page`
`Landing page`
`Scrollbars page`
`Text input page`

> Reasons: To cover the most important modules that any SUT would have, starting from the login, followed by navigation between pages, retrieval of data, dynamic changes of elements, typing texts and its validations.

## Environment Specifications:
> 1. SUT
>     - Web GUI: http://www.uitestingplayground.com/home'
>     - APIs: 'https://petstore.swagger.io/'
> 2. Programming Language: Java 17 
> 3. Automation framework: SHAFT_Engine
> 4. IDE: Intellij
> 5. CI/CD: using github actions
> 6. Project is following the POM design pattern

#### Note: Please note that the framework is already based on maven as a building tool, integrated with TestNG as a testing framework and integrated with Allur for auto-generate reports upon execution

## How to run tests locally:
> 1. As a pre-requisiste, Java needs to be installed on your machine
> 2. Intellij or Eclipse as IDEs will be working fine
> 3. Clone the project from the source control
> 4. Navigate to test classes, then run the class
> 5. After execution, automatic reports will be generated

#### Note: Please note that for using intellij, you will need to edit the run configurations and add the below listeners manually
> `com.shaft.tools.listeners.AlterSuiteListener`, `com.shaft.tools.listeners.SuiteListener`, `com.shaft.tools.listeners.InvokedMethodListener` 

## How to run tests using CI/CD:
> 1. On Github, choose actions, work flow, desktop browser tests
> 2. Click on run workflow, the pipeline will start
> OR, you can trigger the pipeline by 
> 5. After execution, automatic reports will be generated

### Test evidences reports
Attached in the project 2 folders
> 1. Exported reports folder: The exported results from the framework that meant to be uploaded to Calliope.pro
> 2. Evidences folder:  Contains screenshots, stack traces, and responses (if any) for the covered test cases
#### Please note that I tried to upload the exported reports on calliope.pro but faced some troubles, that's why they are attached here in the project.

### Point of improvements for Calliope.pro
> 1. To support more file extensions
> 2. To integrate it with more open sources tools to export the reports directly throughout them

### Next step for this project
> 1. Applying Parallel execution
> 2. Applying remote execution using selenium grid and docker compose
