/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Desktop
 */
public class Cour {
    
    private int id;
    private String nomCour;
    private String descriptionCour;
    private String codeCour;
    
    

    public Cour() {
    }

    public Cour(String nomCour, String descriptionCour, String codeCour) {
        this.nomCour = nomCour;
        this.descriptionCour = descriptionCour;
        this.codeCour = codeCour;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
