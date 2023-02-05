drop schema if exists user_schema cascade;

create schema user_schema;

create table user_schema.users(
    id serial primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNumber varchar(50) not null,
    password varchar(50) not null
);