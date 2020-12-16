# real-customer

## Requirements

The use cases that need to be implemented are:

* Sign up
  * A new user requests to register to our service, providing its username and password.
  * Username must be unique, from 5 to 10 alphanumeric characters.
  * Password from 8 to 12 alphanumeric characters.
* Request friendshipRequest
  * A registered user requests friendshipRequest to another registered user.
  * A user cannot request friendshipRequest to himself or to a user that already has a pending request from him.
* Accept friendshipRequest
  * A registered user accepts a requested friendshipRequest.
  * Once accepted both users become friends forever and cannot request friendshipRequest again.
* Decline friendshipRequest
  * A registered user declines a requested friendshipRequest.
  * Once declined friendshipRequest can be requested again.
* Friends
  * List friends of a registered user.

![Classes Diagram](https://github.com/yaninagm/social-network-test/blob/develop/src/main/resources/relationship.png)


## EndPoints
### POST /friendship/request
?usernameFrom=#usernameFrom&usernameTo=#usernameTo -H X-Password:

### POST /friendship/accept
?usernameFrom=#usernameFrom&usernameTo=#usernameTo -H X-Password:

### POST /friendship/decline
?usernameFrom=#usernameFrom&usernameTo=#usernameTo -H X-Password:

### GET /friendship/list
?username=#username -H X-Password:

### POST /signup
?username=#username  -H X-Password:

## Build & Run
gradle clean bootRun -Pdev

`./gradlew bootRun`

## Run Test
gradle clean bootRun -Ptest


bash -c scripts/legacy-test


## Distancia entre image embedding

https://scikit-learn.org/stable/modules/metrics.html#metrics





Dec 10 00:01:03 real-customer app[web] info 2020-12-09 23:01:02.610  WARN 4 --- [io-37942-exec-6] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 1054, SQLState: 42S22 
Dec 10 00:01:03 real-customer app[web] info 2020-12-09 23:01:02.610 ERROR 4 --- [io-37942-exec-6] o.h.engine.jdbc.spi.SqlExceptionHelper   : Unknown column 'productide0_.id' in 'field list' 
Dec 10 00:01:03 real-customer app[web] info 2020-12-09 23:01:02.611 ERROR 4 --- [io-37942-exec-6] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.dao.InvalidDataAccessResourceUsageException: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet] with root cause 
Dec 10 00:01:03 real-customer app[web] info
Dec 10 00:01:03 real-customexr app[web] info java.sql.SQLSyntaxErrorException: Unknown column 'productide0_.id' in 'field list'



curl -X POST 'http://localhost:8080/qrByProduct'   -H "Content-Type: application/json" --data '{
"id":1,
"name":"lalala",
"urlQrId":"8989",
"dinamicUrl":"www.milanuncios.com",
"dateCreated":"",
"description":"lelelel"
}'


para los nombres camelizados poner:
spring:
  jpa:
    hibernate:
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl