CREATE TABLE filter (
    id binary(16) default (uuid()),
    filter_name varchar(255) not null,
    selection varchar(10),
    primary key (id)
);

CREATE TABLE criteria (
    id binary(16) default (uuid()),
    filter_type varchar(10) not null,
    filter_condition varchar(20) not null,
    value varchar(255) not null,
    filter_id binary(16) not null,
    primary key (id),
    foreign key (filter_id) references filter(id)
);
