package com.mehditmimi.sqlite.dao;

import com.mehditmimi.sqlite.beans.Etudiant;

import java.util.List;

public interface EtudiantDao {
    public Etudiant addEtudiant(Etudiant etudiant);
    public List<Etudiant> getEtudiants();
}
