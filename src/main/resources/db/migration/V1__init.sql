CREATE TABLE IF NOT EXISTS users
(id SERIAL PRIMARY KEY,
    username VARCHAR(20)  NOT NULL,
    password VARCHAR(200) NOT NULL,
    email    VARCHAR(50)  NOT NULL,
    locked   BOOLEAN      NOT NULL DEFAULT FALSE,
    disabled BOOLEAN      NOT NULL DEFAULT FALSE,
    UNIQUE (username),
    UNIQUE (email)
    );

