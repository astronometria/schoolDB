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

INSERT INTO etudiant (nom, Prenom, universite, adresse, ville, province, codePostal, Pays, telephone, email, sexe, dateNaissance)
VALUES
('Smith', 'John', 'University A', '123 Main St', 'City1', 'Province1', '12345', 'Country1', '123-456-7890', 'john.smith@email.com', 'M', '1990-01-01'),
('Johnson', 'Emily', 'University B', '456 Elm St', 'City2', 'Province2', '23456', 'Country2', '234-567-8901', 'emily.johnson@email.com', 'F', '1991-02-02'),
('Davis', 'Michael', 'University C', '789 Oak St', 'City3', 'Province3', '34567', 'Country3', '345-678-9012', 'michael.davis@email.com', 'M', '1992-03-03'),
('Wilson', 'Sophia', 'University D', '101 Pine St', 'City4', 'Province4', '45678', 'Country4', '456-789-0123', 'sophia.wilson@email.com', 'F', '1993-04-04'),
('Miller', 'James', 'University E', '202 Maple St', 'City5', 'Province5', '56789', 'Country5', '567-890-1234', 'james.miller@email.com', 'M', '1994-05-05'),
('Brown', 'Olivia', 'University F', '303 Cedar St', 'City6', 'Province6', '67890', 'Country6', '678-901-2345', 'olivia.brown@email.com', 'F', '1995-06-06'),
('Jones', 'William', 'University G', '404 Birch St', 'City7', 'Province7', '78901', 'Country7', '789-012-3456', 'william.jones@email.com', 'M', '1996-07-07'),
('Garcia', 'Liam', 'University H', '505 Cherry St', 'City8', 'Province8', '89012', 'Country8', '890-123-4567', 'liam.garcia@email.com', 'M', '1997-08-08'),
('Martinez', 'Ava', 'University I', '606 Walnut St', 'City9', 'Province9', '90123', 'Country9', '901-234-5678', 'ava.martinez@email.com', 'F', '1998-09-09'),
('Taylor', 'Ella', 'University J', '707 Pineapple St', 'City10', 'Province10', '01234', 'Country10', '012-345-6789', 'ella.taylor@email.com', 'F', '1999-10-10');
