## Wonderful Internet Movie Project!

### G4C Homework Project for Week 5

#### Deployment Details

Deployed to Heroku here as a Java project:

https://wimp-app-jon-g4c-indy-nov.herokuapp.com

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
