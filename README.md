## Wonderful Internet Movie Project!

### G4C Homework Project for Week 5

Spring Framework
JPA
Hibernate ORM
PostgreSQL Database

**Database Details:**

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
