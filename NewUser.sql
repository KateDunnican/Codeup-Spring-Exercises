# Ran these commands in the terminal

CREATE DATABASE spring_db;

CREATE USER spring_user@localhost IDENTIFIED BY '*BlackKitty5';
GRANT ALL ON spring_db.* TO spring_user@localhost;
