--PostgreSQL10

CREATE DATABASE "student_directory";

CREATE USER tester WITH PASSWORD 'test_password';

GRANT ALL PRIVILEGES ON DATABASE student_directory to tester;

GRANT USAGE ON SCHEMA student_directory.public TO tester;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA student_directory.public TO tester;

GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA student_directory.public TO tester;

CREATE SEQUENCE "student_id_seq";

CREATE TABLE student (
                         "id" smallint NOT NULL DEFAULT nextval('student_id_seq'),
                         "first_name" varchar(45) DEFAULT NULL,
                         "last_name" varchar(45) DEFAULT NULL,
                         "patronymic" varchar(45) DEFAULT NULL,
                         "birth_date" date DEFAULT NULL,
                         "study_group" varchar(45) DEFAULT NULL,
                         PRIMARY KEY ("id")
);
