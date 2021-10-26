## Installation

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `SpringBatchWithSpringBootApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command 

```shell
$ git clone https://github.com/AnanthaRajuC/Spring-Batch-With-Spring-Boot.git
$ cd Spring-Batch-With-Spring-Boot
$ mvn clean package
$ java -jar target/spring-batch-with-spring-boot-latest.jar "item=shoes" "run.date(date)=2020/01/01"
```
