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