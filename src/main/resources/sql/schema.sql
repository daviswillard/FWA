drop schema if exists user_schema cascade;

create schema user_schema;

create table user_schema.users(
    id serial primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNumber varchar(15) not null,
    password varchar(200) not null
);