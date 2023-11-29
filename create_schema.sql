CREATE DATABASE IF NOT EXISTS school;


-- Drop tables with foreign key constraints
DROP TABLE IF EXISTS etudiant_cour;
DROP TABLE IF EXISTS cour;
DROP TABLE IF EXISTS etudiant;

-- Drop remaining tables
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`username`)
);

INSERT INTO `user` (username, password) VALUES ('admin', 'admin');

CREATE TABLE etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    Prenom VARCHAR(255),
    universite VARCHAR(255),
    adresse VARCHAR(255),
    ville VARCHAR(255),
    province VARCHAR(255),
    codePostal VARCHAR(10),
    Pays VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255),
    sexe CHAR(1),
    dateNaissance VARCHAR(255)  
);

CREATE TABLE cour (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomCour VARCHAR(255),
    descriptionCour TEXT,
    codeCour VARCHAR(255) NOT NULL
);

-- Create etudiant_cour table
CREATE TABLE etudiant_cour (
    etudiant_id INT,
    cour_id INT,
    code_cour VARCHAR(50),
    NoteFinale DECIMAL(5, 2),
    Semestre INT,
    Annee INT,
    PRIMARY KEY (etudiant_id, cour_id),
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id),
    FOREIGN KEY (cour_id) REFERENCES cour(id)
);