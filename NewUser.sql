CREATE DATABASE spring_db;

CREATE USER spring_user@localhost IDENTIFIED BY '*BlackKitty5';
GRANT ALL ON spring_db.* TO spring_user@localhost;

INSERT INTO posts (title, body)
VALUES  ('Post 1', 'Body of post 1'),
        ('Post 2', 'Body of post 2'),
        ('Post 3', 'Body of post 3'),
        ('Post 4', 'Body of post 4');
