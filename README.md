# Car Dealership System

This project is a web application which manages the cars sold at three different car dealerships. It performs CRUD (Create, read, update and delete), search and purchase 
functions/operations on any car from any dealerships.

Programming language: Java

Java Framework: Spring Boot

Type: Maven

Dependencies used: Spring Web, Thymeleaf, Lombok, Spring data JDBC and H2 database

## Some sample screenshots of Project

### Homepage
![Screesshot of Homepage](https://github.com/Dev-Daljeet/Screenshots/blob/master/CarDealership/Deafult.jpg?raw=true)

### Add page
![Screesshot of add page](https://github.com/Dev-Daljeet/Screenshots/blob/master/CarDealership/add.jpg?raw=true)

### View page
![Screesshot of view page](https://github.com/Dev-Daljeet/Screenshots/blob/master/CarDealership/view.jpg?raw=true)

### Search page
![Screesshot of search page](https://github.com/Dev-Daljeet/Screenshots/blob/master/CarDealership/search.jpg?raw=true)


## Usage examples (How to use):
[![CarDealership](https://res.cloudinary.com/marcomontalbano/image/upload/v1605137890/video_to_markdown/images/youtube--Wh6eOBVedmg-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://youtu.be/Wh6eOBVedmg "CarDealership")

## Run:
### Prerequisites (Requirements):

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.devdaljeet.cardealershipsystem.CarDealershipSystemApplication` class from your IDE (Eclipse).

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/Dev-Daljeet/CarDealershipSystem.git
$ cd CarDealershipSystem
$ mvn spring-boot:run
```

# License
MIT License
Copyright (c) 2020 Dev-Daljeet

Refer to **LICENSE** file for full information.
