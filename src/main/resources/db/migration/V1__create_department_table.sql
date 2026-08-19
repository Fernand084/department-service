CREATE SEQUENCE department_id_seq START WITH 1;

CREATE TABLE department (
    id CHAR(4) PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL
);

ALTER SEQUENCE department_id_seq OWNED BY department.id;