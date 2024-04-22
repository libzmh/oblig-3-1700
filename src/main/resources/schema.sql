CREATE TABLE kino
(
    id        INTEGER AUTO_INCREMENT,
    movie     VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    surname   VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    telephone INTEGER,
    tickets   INTEGER      NOT NULL,
    PRIMARY KEY (id)
);