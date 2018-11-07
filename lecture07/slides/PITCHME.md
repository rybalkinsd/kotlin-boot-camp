---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 7
#### Working with Databases


---
@title[Sign in]
<!-- .slide: class="center" -->

Please [**sign in**](https://sphere.mail.ru/)
 
*For off-line students only*


---
@title[Get ready]
<!-- .slide: class="center" -->
```bash
git fetch upstream
git checkout -b lecture07 upstream/lecture07
cd lecture07
```

open as new project

---
@title[Agenda]
1. @css[highlight](Google cloud shell)
1. Local setup (Not needed if using google cloud shell)
1. Database basics
1. SQL basics
1. Kotlin + DB

---
@title[Google Cloud Platform]
https://cloud.google.com/  
This is one of the leading cloud services platforms  
Please register here

---
@title[Google cloud shell]
https://cloud.google.com/shell/  
This is a linux machine that is given for every user of Google Cloud Platform for free  
It has everything we need on board:
- A temporary virtual machine instance
- Command-line access to the instance from a web browser
- 5 GB of persistent disk storage
- Pre-installed Google Cloud SDK and other tools
- Language support for Java, Go, Python, Node.js, PHP, Ruby and .NET
- Public DNS (Web preview)
  
https://cloud.google.com/shell/docs/features

---
@title[Check your google cloud shell]
```bash
git --version
java -version
javac -version
psql --version
```

---
@title[Agenda]
1. Google cloud shell
1. @css[highlight](DB Setup)
1. Database basics
1. SQL basics
1. Kotlin + DB

---
@title[Install postgreSQL client. (Not needed if using google shell)]
Install the PostgreSQL client

linux
```bash
apt-get install postgresql-9.5
```

windows [[Download page]](https://www.postgresql.org/download/windows/)


mac
```bash
> brew install postgres
``` 

---
@title[DB Server]
We did setup DB server in cloud for you:  
Machine address: @css[highlight](54.224.37.210)  
Port: @css[highlight](5432)  
You have individual database, use your assigned number:  
database name is @css[highlight](chatdb_atomN)  
user name is @css[highlight](atomN)  

---
@title[Check db connection]

```bash
> psql -h 54.224.37.210 -U atomN -d chatdb_atomN
> enter your password
>> psql (9.6.2, server 9.2.18)
>> Type "help" for help.
```
```postgresql
select * from pg_catalog.pg_tables;
```

---
@title[psql commands]
```bash
#exit
\q 
#list all schemas
\dn
#list all tables in all schemas
\dt *.
#describe table
\d+ tablename
```
---

@title[Agenda]
1. Google cloud shell
1. DB Setup
1. @css[highlight](Database basics)
1. SQL basics
1. Kotlin + DB


---
@title[Storage comparison]
**RAM** vs **File**  
- Capacity
- Speed
- Durability


---
@title[Storage comparison]
**File** vs **Database**
- Store overhead
- Consistency
- Guarantees
- Speed

---
@title[Database (RDBMS)]
Is a
    
    Collection of related data
    
Where

    Data can be easily accessed

Within

    Management system


---
@title[Many different types of DBs]
- SQL/[NoSQL](https://en.wikipedia.org/wiki/NoSQL)
- In-memory/disk storage
- stand-alone/embedded
- ...

---
@title[Transaction]
Transaction is a unit of work

- Recovery
- ACID
    - Atomicity
    - Consistency
    - Isolation
    - Durability

---
@title[Agenda]
1. Google cloud shell
1. DB Setup
1. Database basics
1. @css[highlight](SQL basics)
1. Kotlin + DB

---
@title[PostgreSQL]
Popular DBMS (heavily used in production for years)
[[Official doc]](https://www.postgresql.org/docs/9.2/static/index.html)  
All examples below are in PostgreSQL
---
@title[Table]
```postgresql
create table "user" (
  id    serial             not null,
  login varchar(20) unique not null
);
```
```postgresql
\d+ user;
```
```postgresql
drop table "user";
```
**Note - you can not name table or column with reserved name css[highlight](user)**

[[Read more about `serial`]](https://www.tutorialspoint.com/postgresql/postgresql_using_autoincrement.htm)


---
@title[Primary key]
Indicates that a column or group of columns can be used as a unique identifier for rows in the table

```postgresql
create table chat.user (
  id    serial             not null,
  login varchar(20) unique not null,

  primary key (id)
);
```


---
@title[Schema]
A schema is essentially a namespace.

```postgresql
create schema chat;
```

```postgresql
create table chat.user (

)
```

[[Read more]](https://www.postgresql.org/docs/9.3/static/sql-createschema.html)


---
@title[First schema]
@See resources/sql/schema/schema-1-simple.sql


---
@title[CRUD]
1. **insert** for create
1. **select** for read
1. **update** for update
1. **delete** for delete 


---
@title[select]
```postgresql
select *
from chat.message
where time > '2017-03-25';
```

[[Read more]](https://www.postgresql.org/docs/9.2/static/sql-select.html)

---
@title[insert]
```postgresql
insert into chat.user (login)
values ('admin');
```

[[Read more]](https://www.postgresql.org/docs/9.2/static/sql-insert.html)

---
@title[delete]
```postgresql
delete from chat.user 
where login = 'admin';
```

[[Read more]](https://www.postgresql.org/docs/9.2/static/sql-delete.html)


---
@title[Constraints]
Imagine a user with lots of messages in history.

What happens when we delete this user?


---
@title[Constraints]
```postgresql
drop table if exists chat.message;
create table chat.message (
  id     serial       not null,
  "user" integer      not null references chat.user on delete cascade,
  time   timestamp    not null,
  value  varchar(140) not null,

  primary key (id)
);
```

What if chat.user has a complex pk?

[[Read more]](https://www.postgresql.org/docs/9.2/static/ddl-constraints.html)


---
@title[Second schema]
@See resources/sql/schema/schema-2-constraints.sql


---
@title[What if one of queries is broken?]
```postgresql
create table "user"();

create table NoSuChScHeMa.message(); 

insert into message ("user", time, value) 
values ('admin', now(), 'super message') 
```


---
@title[Transaction]
```postgresql
begin;
{statements}
commit;
```


---
@title[Third schema]
@See resources/sql/schema/schema-3-transaction.sql


---
@title[Agenda]
1. Google cloud shell
1. DB Setup
1. Database basics
1. SQL basics
1. @css[highlight](Kotlin + DB)

---
@title[Practice]

---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
