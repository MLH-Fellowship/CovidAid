# Backend for CovidAid
---
### Technology Stack
- Poetry (dependency management)
- Flask (backend framework)
- PostgreSQL (relational database)
- SQLAlchemy (object relational mapper)

### Prerequistes
1. Python3
2. Poetry
3. PostgreSQL

### Setting up development environment

1. Cloning the repository

```shell
$ git clone https://github.com/NitishGadangi/CovidAid.git
$ cd CovidAid/backend/
```

2. Setting up poetry

```shell
$ poetry install   # to install dependencies

# and finally
$ poetry shell
```

3. Setting up PostgreSQL
```sql
-- in the 'psql' prompt

user=# create database covidaid;
```

In your shell
```shell
$ flask db upgrade
```

4. Finally, start the development server

```shell
$ flask run
```
