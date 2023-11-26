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

-- Generate random associations between students and courses
-- Each student will be assigned a random number of random courses
DELIMITER $$
CREATE PROCEDURE InsertRandomAssociations()
BEGIN
    DECLARE student_count INT DEFAULT 1;
    DECLARE course_count INT;
    DECLARE student_id INT;
    DECLARE course_id INT;
    DECLARE i INT;

    WHILE student_count <= 10 DO
        -- Generate a random number of courses to assign to the student (between 1 and 5)
        SET course_count = FLOOR(RAND() * 5) + 1;
        SET i = 1;

        -- Assign random courses to the student
        WHILE i <= course_count DO
            -- Select a random student and a random course
            SET student_id = FLOOR(RAND() * 10) + 1;  -- Assuming 10 students
            SET course_id = FLOOR(RAND() * 10) + 1;   -- Assuming 10 courses

            -- Insert the association if it doesn't already exist
            INSERT IGNORE INTO etudiant_cour (etudiant_id, cour_id, code_cour)
            VALUES (student_id, course_id, (SELECT codeCour FROM cour WHERE id = course_id));

            SET i = i + 1;
        END WHILE;

        SET student_count = student_count + 1;
    END WHILE;
END$$
DELIMITER ;

-- Call the procedure to generate random associations
CALL InsertRandomAssociations();
