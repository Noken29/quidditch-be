CREATE TABLE posts (
    id BIGSERIAL NOT NULL,
    name VARCHAR(512),
    content VARCHAR(1024),
    posted TIMESTAMP(6),
    PRIMARY KEY (id)
);