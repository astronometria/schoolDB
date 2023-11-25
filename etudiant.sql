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
