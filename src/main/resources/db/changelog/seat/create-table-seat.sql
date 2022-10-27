--liquibase formatted sql
--changeset leonidromanov:1
create table seat (
    id  bigserial not null,
    aircraft varchar(50) not null,
    seat_number varchar(10) not null,
    fare int,
    is_registered boolean not null,
    is_sold boolean not null,
    seat_category varchar(50) not null,
    primary key (id)
);