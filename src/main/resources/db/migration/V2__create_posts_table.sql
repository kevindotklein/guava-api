CREATE TABLE posts(
    id UUID,
    title VARCHAR(350) NOT NULL,
    content TEXT NOT NULL,
    hearts INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT posts_pk PRIMARY KEY (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users(id)
)
