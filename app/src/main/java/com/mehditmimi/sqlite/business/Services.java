package com.mehditmimi.sqlite.business;

import com.mehditmimi.sqlite.beans.Etudiant;
import com.mehditmimi.sqlite.beans.Option;

import java.util.List;

public interface Services {
    public Etudiant addEtudiant(Etudiant etudiant);
    public List<Etudiant> getEtudiants();
    public Option addOption(Option option);
    public List<Option> getOptions();
}
