# Java Spring Configuration:

## Simple schema.sql
```
  DROP TABLE IF EXISTS todo;
  CREATE TABLE tbl_todo(
      id varchar(36) not null primary key,    
      title varchar(255) not null,    
      description varchar(255) not null,    
      created timestamp,    
      modified timestamp,    
      completed boolean);
```
## Spring Data JDBC Datasource H2 Config:
```
  spring.datasource.url=jdbc:h2:mem:hey_db
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  #spring.jpa.defer-datasource-initialization=true
  #http://localhost:8080/h2-console
  spring.h2.console.enabled=true

  logging.level.org.springframework.data=INFO
  logging.level.org.springframework.jdbc.core.JdbcTemplate=DEBUG
```

## Spring Data JDBC ToDo CRUD Scripts:

```
  private static final String SQL_INSERT = "insert into tbl_todo (id, title, description, created, modified, completed) values (:id,:title,:description,:created,:modified,:completed)";
  private static final String SQL_QUERY_FIND_ALL = "select id, title, description, created, modified, completed from tbl_todo";
  private static final String SQL_QUERY_FIND_BY_ID = SQL_QUERY_FIND_ALL +" where id = :id";
  private static final String SQL_UPDATE = "update tbl_todo set title = :title, description = :description, modified = :modified, completed = :completed where id = :id";
  private static final String SQL_DELETE = "delete from tbl_todo where id = :id ";
```

## Spring Data JPA Datasource PostgresSQL Config:
```
spring.profiles.active=${SPRING_PROFILES_ACTIVE:main}
spring.banner.location=${spring.profiles.active}.banner.txt

# PostgreSQL
spring.datasource.url=jdbc:postgresql://server_name:portst/database_name
spring.datasource.username=username
spring.datasource.password=password

# JPA (JpaBaseConfiguration, HibernateJpaAutoConfiguration)
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```

  
