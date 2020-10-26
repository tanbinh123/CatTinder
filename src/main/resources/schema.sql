// use UTF-8 when setting up MariaDB! 

DROP TABLE cat;
DROP TABLE breed;

CREATE TABLE cat
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,name VARCHAR(250) NOT NULL
,description VARCHAR(250) NOT NULL
,image_url VARCHAR(250)
,location VARCHAR(250),
female BOOLEAN
,birth_year BIGINT
, breed_id BIGINT);

CREATE TABLE breed
(breed_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,breed_name VARCHAR(250) NOT NULL
,description VARCHAR(250));

INSERT INTO breed (breed_name, description) VALUES ("European shorthair", "Common cat in Europe with versatile characteristics"), 
("Ragdoll", "American longhaired breed with very social temperament"), 
("Siamese", "Asian shorthaired breed with distinctive mask and markings and very active character"),
("Norwegian Forest Cat", "Longhaired breed that likes outdoors and is active and smart.");

INSERT INTO cat (name, description, location, female, birth_year, breed_id)
VALUES ("Gizmo", "Shy but friendly", "Helsinki", true, 2019, 1), 
("Viiru", "Loves food", "Helsinki", true, 2019, 1),
("Angelo", "Naughty cat", "Hyvinkää", false, 2007, 2);