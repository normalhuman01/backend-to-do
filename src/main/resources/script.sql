CREATE DATABASE todo;
\c todo

CREATE TABLE task (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    state BOOLEAN NOT NULL
);

INSERT INTO task (description, state) VALUES ('Esta es una tarea de prueba 1', false);
INSERT INTO task (description, state) VALUES ('Esta es una tarea de prueba 2', false);
