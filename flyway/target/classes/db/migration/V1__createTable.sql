create table flyway_table
(
    id   integer not null
        constraint flyway_table_pkey
            primary key,
    des  varchar(255),
    name varchar(255)
);
