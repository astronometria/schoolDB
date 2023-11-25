CREATE TABLE etudiant_cour (
    etudiant_id INT,
    cour_id INT,
    PRIMARY KEY (etudiant_id, cour_id),
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id),
    FOREIGN KEY (cour_id) REFERENCES cour(id)
);
