
Commands to run test suite:
mvn surefire:test
or
mvn test -Dbrowser=firefox
mvn test -Dbrowser=chrome

Tools, plugins used:
JDK 8+
Apache Maven
IntelliJ with :
	- Cucumber for Java
	- Gherkin
	- JUnit
	- Maven
	- Lombok



src
|---main
|    |----- java
|    |       |----- pages		
|    |       |        |------pages		
|    |       |        |------locators		
|    |       |----- util		 
|    |       |        |------enums		
|    |       |        |------helpers		
|    |       |        |------objects		
|    |       |        |------webdriverProvider	
|    |----- resources 	
|---test
|    |----- java
|    |       |----- hooks		
|    |       |----- runners		
|    |       |----- steps		
|    |----- resources		
|    |       |----- features		
