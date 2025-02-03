CREATE TABLE users(
    id UUID,
    email VARCHAR(350) NOT NULL UNIQUE,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
)
