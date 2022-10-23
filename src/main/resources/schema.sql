-- create a table for OOO
create table OOO
(
    id     BIGINT(20) NOT NULL AUTO_INCREMENT,
    name   VARCHAR(100) NOT NULL,
    family VARCHAR(100),
    active BOOLEAN,
    PRIMARY KEY (id)
);