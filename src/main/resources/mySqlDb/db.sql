CREATE DATABASE IF NOT EXISTS hibernate_test_db;

USE hibernate_test_db;

CREATE TABLE IF NOT EXISTS owners (
  id          INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  first_name  VARCHAR(45)                        NOT NULL,
  second_name VARCHAR(45)                        NOT NULL,
);

CREATE TABLE IF NOT EXISTS pets (
  pets_id     INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  kind_of_pet VARCHAR(45)     NOT NULL,
  pets_name   VARCHAR(45)     NOT NULL,
  owner_id    INT(11)         NOT NULL,
  INDEX ownerId_idx (owner_id ASC),
  CONSTRAINT ownerId
  FOREIGN KEY (owner_id)
  REFERENCES owners (id)
);

# ????????
CREATE TABLE IF NOT EXISTS pets (
  pets_id     INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  kind_of_pet VARCHAR(45)         NOT NULL,
  pets_name   VARCHAR(45)         NOT NULL,
  owner_id    INT(11)             NOT NULL,
  INDEX ownerId_idx (owner_id ASC)
);

CREATE TABLE IF NOT EXISTS catalog (

  id_student INT NOT NULL,
  id_book    INT NOT NULL
)


