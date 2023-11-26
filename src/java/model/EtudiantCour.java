package model;

public class EtudiantCour {

    private int etudiantId;
    private int courId;
    private Double noteFinale; // Final grade
    private int semestre;     // Semester
    private int annee;        // Year

    // Fields for course details
    private String nomCour;        // Course name
    private String descriptionCour; // Course description
    private String codeCour;        // Course code

    // Default constructor
    public EtudiantCour() {
    }

    // Getters and Setters
    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public int getCourId() {
        return courId;
    }

    public void setCourId(int courId) {
        this.courId = courId;
    }

    public Double getNoteFinale() {
        return noteFinale;
    }

    public void setNoteFinale(Double noteFinale) {
        this.noteFinale = noteFinale;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNomCour() {
        return nomCour;
    }

    public void setNomCour(String nomCour) {
        this.nomCour = nomCour;
    }

    public String getDescriptionCour() {
        return descriptionCour;
    }

    public void setDescriptionCour(String descriptionCour) {
        this.descriptionCour = descriptionCour;
    }

    public String getCodeCour() {
        return codeCour;
    }

    public void setCodeCour(String codeCour) {
        this.codeCour = codeCour;
    }

    // Optionally, override toString, equals, and hashCode methods as needed.
}
