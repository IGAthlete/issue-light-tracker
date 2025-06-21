--liquibase formatted sql

--changeset user:001-create-catalog
CREATE TABLE catalog (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

--rollback DROP TABLE catalog;