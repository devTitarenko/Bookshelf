_**BOOKSHELF**_
-------------------------
_________________________

Spring Boot RESTful Web Service.


For launching
-------------------------
Scripts for creating DB schema and user:
 
`create database Zlatan;`

`create user 'Zlatan'@'localhost' identified by 'Zlatan';`

`grant all on Zlatan.* to 'Zlatan'@'localhost';`

By default port is: **9000**.

Look for properties: `\src\main\resources\application.properties`.


Credentials for login
-------------------------

Login: **Zlatan**

Password: **Zlatan**


Examples of URL queries
-------------------------

Some GET Request Methods:

http://localhost:9000/home - Welcome page

http://localhost:9000/book/all - view all books

http://localhost:9000/author/all - view all authors

http://localhost:9000/author/add?firstName=Stephen&lastName=King - create the author by passing the parameters

http://localhost:9000/author/info/{id} - view full info of author by id

http://localhost:9000/author/info/short/{id} - view short info of author by id

Also available DELETE, PUT and POST Requests.


Technologies
-------------------------
- Java 8
- Spring Boot
- Spring data + Hibernate
- MySQL
- Spring Security
- Gradle
- JUnit/Mockito