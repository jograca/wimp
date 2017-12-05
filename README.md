## Wonderful Internet Movie Project!

### G4C Homework Project for Week 5

#### Definitions

* **PostgreSQL:** Relational (Structured) Database
* **JPA:** Java Persistence API. Specification that defines the Annotations and and Implementations that make ORM possible
* **Hibernate:** Object Relational Mapping (ORM) Framework which Implements JPA, and is used by Spring Data within the Spring Framework. Used to map Data Transfer Objects (DTO) and Plain Old Java Objects (POJOs) written in Java to a Relational Database

#### Database Details:

```
Table "public.movie"
Column    |            Type             | Collation | Nullable | Default
--------------+-----------------------------+-----------+----------+---------
id           | bigint                      |           | not null |
budget       | bigint                      |           |          |
distributor  | character varying(500)      |           | not null |
release_date | timestamp without time zone |           |          |
title        | character varying(300)      |           | not null |
Indexes:
"movie_pkey" PRIMARY KEY, btree (id)
```

```
                               Table "public.actor"
      Column       |            Type             | Collation | Nullable | Default
-------------------+-----------------------------+-----------+----------+---------
 id                | bigint                      |           | not null |
 active_since_year | bigint                      |           |          |
 birth_date        | timestamp without time zone |           |          |
 first_name        | character varying(75)       |           | not null |
 last_name         | character varying(75)       |           |          |
Indexes:
    "actor_pkey" PRIMARY KEY, btree (id)
```
