# mantra
Central Repo for all code base

* 1. swagger implementation 
 * a. dependency to be added
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
 * b. Annotation to be added at the SpringBoot initializer class  : @EnableSwagger2
 * c. Swagger url for the api : http://localhost:8080/swagger-ui.html#/

* 2. Ulility service *****
 * a. added API which copied the file from one location to another
		assumption is that file name would be containing yearMonth

	
