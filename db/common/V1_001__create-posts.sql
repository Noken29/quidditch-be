CREATE TABLE posts (
    id BIGSERIAL NOT NULL,
    name VARCHAR(255),
    content VARCHAR(1021),
    posted TIMESTAMP(6),
    PRIMARY KEY (id)
);