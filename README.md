## Wonderful Internet Movie Project!

### G4C Homework Project for Week 5

#### Deployment Details

Deployed to Heroku here as a Java project:

https://wimp-app-jon-g4c-indy-nov.herokuapp.com

Here's what Heroku does (I think)

* Gathers your code from your Git repository
* Reads your <<pom.xml>> and builds your App based on those details
* Creates a container with your build
* Takes your container and deploys it to their ecosystem
* Your container is considered ephemeral, and will be removed by Heroku if not in active use (A Good Thing). There are probably overrides or whatever
* The Container Ecosystem Heroku uses deploys your container to their service running on an AWS EC2 instance

#### Functionality:

* Add an Actor to a Movie:
* POST to ```/api/movies/{movieId}/actors``` passing the {{actorId}}

* Add an Award to an Actor:
* POST to ```POST	/api/actors/{actorId}/awards``` passing an award entity

* See Movies and Awards with Actors:
* GET to ```/api/actors/{id}```

* See Actors and Movies with Awards
* GET to ```/api/movies/{id}```

#### Footnote - Definitions

* **PostgreSQL:** Relational (Structured) Database
* **JPA:** Java Persistence API. Specification that defines the Annotations and and Implementations that make ORM possible
* **Hibernate:** Object Relational Mapping (ORM) Framework which Implements JPA, and is used by Spring Data within the Spring Framework. Used to map Data Transfer Objects (DTO) and Plain Old Java Objects (POJOs) written in Java to a Relational Database
