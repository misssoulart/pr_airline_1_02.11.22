--liquibase formatted sql

--changeset mishinyura:1
drop table if exists documents;

create table documents
(
    id          bigserial   not null,
    type        varchar(50) not null,
    number      varchar(50) not null,
    expiry_date date,
    created_at  timestamp   not null,
    updated_at  timestamp   not null,
    passenger_id int8       not null,
    version     int8        not null,
    primary key (id)
);

--rollback drop table if exists documents;
