CREATE DATABASE IF NOT EXISTS hibernate_test_db;

USE hibernate_test_db;

CREATE TABLE IF NOT EXISTS owners (
  id          INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  first_name  VARCHAR(45)                        NOT NULL,
  second_name VARCHAR(45)                        NOT NULL,
);


CREATE TABLE IF NOT EXISTS pets (
  id          INT(11) AUTO_INCREMENT PRIMARY KEY    NOT NULL,
  name        VARCHAR(100)                          NOT NULL,
  user_id     VARCHAR(100)                          NOT NULL
);

CREATE TABLE IF NOT EXISTS catalog (

  id_student INT NOT NULL,
  id_book    INT NOT NULL
)


