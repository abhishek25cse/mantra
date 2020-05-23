# mantra
Central Repo for all code base. This has detail for the various implementation of Spring

* swagger implementation 
 	* dependency to be added
		<br/>\<dependency\>
		<br/>    \<groupId\>io.springfox\</groupId\>
		<br/>        \<artifactId\>springfox-swagger2\</artifactId\>
		<br/> 	 \<version\>2.9.2\</version\>
		<br/>\</dependency\>
		<br/>\<dependency\>
		<br/>  	 \<groupId\>io.springfox\</groupId\>
		<br/>	 \<artifactId\>springfox-swagger-ui\</artifactId\>
		<br/>	 \<version\>2.9.2\</version\>
		<br/></dependency>
 	*  Annotation to be added at the SpringBoot initializer class  : @EnableSwagger2
 	*  Swagger url for the api : http://localhost:8080/swagger-ui.html#/

* Ulility service
	 *  added API which copied the file from one location to another.
		<br/>Assumption is that file name would be containing yearMonth

	
