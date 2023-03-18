DROP TABLE IF EXISTS todo;

CREATE TABLE tbl_todo(
 id varchar(36) not null primary key,
 title varchar(255) not null,
 description varchar(255) not null,
 created timestamp,
 modified timestamp,
 completed boolean
);