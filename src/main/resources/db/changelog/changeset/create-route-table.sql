create table route (
                       id  bigserial not null,
                       arrival_date date,
                       category varchar(255),
                       departure_date date,
                       destination_from varchar(255),
                       destination_to varchar(255),
                       number_of_seats int4,
                       primary key (id)
)