# Spring Boot Web API - User Controller

## Project Description

<div align="center">
<img width="400" alt="webapi_thumb" src="https://github.com/user-attachments/assets/5e68eb64-0a6d-4439-a7bb-ecf93df79c44" />
</div>

The Spring Boot Web API Demo is a web API project developed using Java and Spring Boot, designed to provide basic RESTful services. It's an ideal starting point for anyone who wants to quickly learn CRUD operations, API testing, and modern web service architecture.

This project uses Java Spring Boot, a widely preferred framework in enterprise applications with strong community support. The RESTful architecture is adopted, and the Model-View-Controller (MVC) design pattern is applied. DTOs (Data Transfer Objects) are used for secure and flexible data transport. UUIDs are preferred for user identifiers to ensure uniqueness and security. To enhance maintainability and safety, immutable objects and encapsulation (private/final variables) are used wherever possible. The API is tested using Postman and Swagger UI.

## Requirements

Before starting the project, ensure the following software is installed:

* **Java JDK 17+**
  [Download OpenJDK](https://adoptium.net/)
* **Git**
  [Download Git](https://git-scm.com/downloads)
* **IDE:** IntelliJ IDEA, Eclipse, or VS Code ([Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack))
* **Maven** (comes with the project as a wrapper)
* (Optional) **Postman** or **Swagger UI** for API testing

## Installation Steps

1. **Clone the Project:**

```bash
git clone https://github.com/yourusername/Spring-Boot-WebAPI.git
cd Spring-Boot-WebAPI
```

2. **Download Dependencies & Build the Project:**

```bash
# Linux/Mac
./mvnw clean install
# Windows
mvnw.cmd clean install
```

3. **Run the Project:**

```bash
# Linux/Mac
./mvnw spring-boot:run
# Windows
mvnw.cmd spring-boot:run
```

4. **Configuration Files:**

Basic settings are located in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.application.name=demo
#server.port=8080
```

You can modify the port or other settings here.

## Usage Guide

After starting the project, you can use the API as shown below:

### Example API Call

```http
POST http://localhost:8080/users/newuser
```

JSON body:

```json
{
  "userName": "user_name",
  "userPassword": "user_password"
}
```

Response:

```json
"User user_name created with id: b77202f8-21e5-4a32-8432-959cf8a5121a"
```

### Testing with Postman

**Installing Postman:**

* [Download Postman](https://www.postman.com/downloads/)
* Open the app and create a new request.

**Usage:**

* Create a new collection and add your API requests.
* For example, to create a user:

  * Method: `POST`
  * URL: `http://localhost:8080/users/newuser`
  * Go to Body → raw → JSON and enter:

    ```json
    {
      "userName": "user_name",
      "userPassword": "user_password"
    }
    ```
  * Press “Send”.

You can test GET, PUT, and DELETE in a similar manner.

### Swagger UI Setup (Optional)

Add this dependency to your `pom.xml` if Swagger is not included:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.7.0</version>
</dependency>
```

Rebuild and restart the project, then navigate to:

```
http://localhost:8080/swagger-ui.html
```

Swagger UI allows you to:

* View all endpoints and descriptions
* Test endpoints directly via “Try it out”
* View request schemas and models

### Example GET Request

```
GET http://localhost:8080/users/{id}
```

Example response:

```json
{
  "id": "b77202f8-21e5-4a32-8432-959cf8a5121a",
  "userName": "user_name"
}
```

## Features

* Quick setup with Spring Boot
* Basic RESTful endpoint examples
* Easily extendable architecture
* Ready-to-use test structure (JUnit)
* Maven-based dependency management

## Project Structure

```
Spring-Boot-WebAPI/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java
│   │   │   ├── controller/
│   │   │   │   └── UserController.java
│   │   │   ├── dto/
│   │   │   │   └── UserRequest.java
│   │   │   └── model/
│   │   │       └── User.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml
├── mvnw / mvnw.cmd
└── ...
```

* **DemoApplication.java:** Entry point of the application.
* **UserController.java:** Contains REST endpoints for user operations.
* **UserRequest.java:** DTO used to receive data from clients.
* **User.java:** User model class.
* **application.properties:** Application configuration file.
* **DemoApplicationTests.java:** Basic test class.
* **pom.xml:** Maven dependency and build configuration.

## Customization

* **Adding a New Endpoint:**
  Create a new controller under `controller/`.
* **Database Integration:**
  Add DB settings inside `application.properties`.
* **Adding New Dependencies:**
  Modify `pom.xml` and run `./mvnw clean install`.

## Troubleshooting

* **JAVA_HOME Error:**
  Ensure JDK is properly installed and environment variables are set.
* **Port Conflict:**
  Change the server port in `application.properties`.
* **Dependency Issues:**
  Run `./mvnw clean install` for a clean build.

## Project Development Summary

During development, multiple languages and frameworks (ASP.NET, PHP, Python Flask, and Spring Boot) were evaluated. Spring Boot was selected due to:

* Strong enterprise usage
* Large, active community
* Robust REST support
* Advanced configuration and security features

The REST architecture ensures scalability and flexibility. MVC design pattern improves readability and maintainability. DTOs are used to expose only necessary fields and maintain data encapsulation.

User IDs are generated using UUID for security and uniqueness. Model fields are defined as `private` and `final` to encourage immutability and safer object design.

The API was tested using Postman and Swagger UI.

---
