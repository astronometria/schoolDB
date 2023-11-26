CREATE TABLE cour (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomCour VARCHAR(255),
    descriptionCour TEXT,
    codeCour VARCHAR(255) NOT NULL
);

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
