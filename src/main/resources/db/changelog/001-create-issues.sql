--liquibase formatted sql

--changeset user:001-create-issues
CREATE TABLE issues (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(700) NOT NULL,
    description TEXT,
    city VARCHAR(50) NOT NULL
);

--rollback DROP TABLE issues;