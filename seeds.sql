

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

INSERT INTO cour (nomCour, descriptionCour, codeCour)
VALUES
('Mathematics', 'A comprehensive introduction to mathematics.', 'MATH101'),
('History of Art', 'Explore the history of art from ancient to contemporary.', 'ARTHIST101'),
('Computer Science Fundamentals', 'Learn the basics of computer science and programming.', 'CS101'),
('Biology and Ecology', 'Study the science of life and ecosystems.', 'BIOLOGY101'),
('Introduction to Psychology', 'An overview of fundamental psychological concepts.', 'PSYCH101'),
('English Literature', 'Explore classic and modern English literature.', 'LIT101'),
('Chemistry Principles', 'A fundamental course in chemistry and chemical principles.', 'CHEM101'),
('Economics and Society', 'An introduction to economics and its impact on society.', 'ECON101'),
('Physics for Beginners', 'Learn the basics of physics and natural phenomena.', 'PHYSICS101'),
('Political Science', 'Study the fundamentals of political science and governance.', 'POLSCI101');

INSERT INTO etudiant_cour (etudiant_id, cour_id, code_cour, NoteFinale, Semestre, Annee)
VALUES

(1, 3, 'CS101', 88.5, 1, 2023),
(1, 5, 'PSYCH101', 79.0, 2, 2023),
(2, 2, 'ARTHIST101', 91.2, 1, 2023),
(2, 4, 'BIOLOGY101', 87.8, 1, 2023),
(3, 1, 'MATH101', 86.7, 1, 2023),
(3, 6, 'LIT101', 75.5, 2, 2023),
(4, 4, 'BIOLOGY101', 88.9, 1, 2023),
(4, 7, 'CHEM101', 90.3, 1, 2023),
(5, 2, 'ARTHIST101', 89.6, 1, 2023),
(5, 8, 'ECON101', 81.2, 2, 2023),
(6, 3, 'CS101', 92.3, 1, 2023),
(6, 9, 'PHYSICS101', 85.1, 1, 2023),
(7, 5, 'PSYCH101', 78.4, 1, 2023),
(7, 10, 'POLSCI101', 89.8, 2, 2023),
(8, 7, 'CHEM101', 91.7, 1, 2023),
(8, 1, 'MATH101', 87.2, 2, 2023),
(9, 8, 'ECON101', 84.6, 1, 2023),
(9, 3, 'CS101', 90.0, 2, 2023),
(10, 9, 'PHYSICS101', 88.2, 1, 2023),
(10, 4, 'BIOLOGY101', 86.5, 2, 2023);