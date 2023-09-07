# BookSearcher Web Service Documentation
Made by: Melih Arslan<br>
Date: 05-09-2023

### Introduction
Welcome to the BookSearcher web service, a tool for searching and filtering books by text and language. 
This documentation will guide you through the service's features, how to get started, and the reasoning behind certain design choices.

# Getting Started
###Prerequisites

Before using the BookSearcher web service, ensure you have the following prerequisites installed:

 - [Java 17](https://www.oracle.com/java/technologies/downloads/) 
 - [Spring Boot](https://spring.io/projects/spring-boot)
 - [Maven](https://maven.apache.org/download.cgi)

### Installation
1. Clone this repository to your local machine: <br>
`git clone https://github.com/MelihArslan/booksearcher.git`
2. Navigate to the project directory in a terminal
3. Install Java dependencies using Maven: <br>
`mvn clean install`
4. Start the Spring Boot backend server:
`mvn spring-boot:run`

# API Documentation
SwaggerUI documentation of the API is available at [http://localhost:8080/](http://localhost:8080/).

# Design Choices
### Spring Boot and Maven
The choice of using Spring Boot and Maven for this project is rooted in my extensive experience gained through a combination of education and professional work.

**Education**

During my academic journey, I had the privilege of studying Software Engineering for my bachelor's degree. It was during this time that I was introduced to the world of Java and Spring Boot. The structured and comprehensive curriculum provided me with a strong foundation in Java programming and Spring Boot framework. 
I gained insights into the principles of microservices architecture, dependency injection, and the ease of building robust and scalable web services with Spring Boot.

**Professional Experience**

While I am still pursuing my degree in Software Engineering, I've been fortunate to gain valuable practical experience as a software developer. 
Starting as a Junior developer, I've recently been promoted to the position of a Medior full-stack developer. During this time, I've had the privilege to work on a variety of projects where Spring Boot and Maven have been essential components of the development stack. 
This hands-on experience has allowed me to explore the capabilities of these technologies in creating efficient and maintainable backend services. 
I've had the opportunity to witness firsthand the benefits of Spring Boot's simplicity, rapid development features, and robust ecosystem for building RESTful APIs.

Maven, as a build and dependency management tool, has been an indispensable companion in my software development journey. Its ability to handle project dependencies, automate builds, and streamline the development process has significantly contributed to the success of my projects. Whether it's managing external libraries or ensuring consistent project structures, Maven has proven its worth time and again.

In summary, the choice of Spring Boot and Maven for the BookSearcher project is not only a result of my familiarity with these technologies but also a testament to their reliability and effectiveness in building high-quality web services.

### Sources
These are the sources which I used to make this webservice:

* [Google Books API: Using the API](https://developers.google.com/books/docs/v1/using)

