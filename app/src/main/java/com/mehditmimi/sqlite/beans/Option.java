package com.mehditmimi.sqlite.beans;

import java.util.List;

public class Option {
    private String nom;
    private String description;
    private List<Etudiant> etudiants;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public String toString() {
        return "Option{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
