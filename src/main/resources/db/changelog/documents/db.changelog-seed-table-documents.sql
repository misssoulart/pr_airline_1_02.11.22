--liquibase formatted sql

--changeset mishinyura:2
insert into documents(type, number, expiry_date, passenger_id, created_at, updated_at, version)
values ('NATIONAL_PASSPORT', 'A1B2', '2025-12-12', 1, now(), now(), 1);

--rollback truncate documents restart identity;
