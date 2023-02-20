drop schema if exists user_schema cascade;

create schema user_schema;

create table user_schema.users(
    id serial primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNumber varchar(15) not null,
    password varchar(200) not null
);

create table user_schema.images(
    owner integer references user_schema.users(id) not null,
    realName varchar(50) not null,
    uniqueName varchar(100) not null,
    mime varchar(50) not null,
    size integer not null
);

create table user_schema.logins(
    owner integer references user_schema.users(id) not null,
    loginTime timestamp default current_timestamp,
    ipAddress varchar(50) not null
)