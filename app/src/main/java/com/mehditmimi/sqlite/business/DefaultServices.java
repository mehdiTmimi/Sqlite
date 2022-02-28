package com.mehditmimi.sqlite.business;

import android.content.Context;

import com.mehditmimi.sqlite.beans.Etudiant;
import com.mehditmimi.sqlite.beans.Option;
import com.mehditmimi.sqlite.dao.EtudiantDao;
import com.mehditmimi.sqlite.dao.EtudiantDaoSqlLite;
import com.mehditmimi.sqlite.dao.OptionDao;

import java.util.List;

public class DefaultServices implements  Services{
    private EtudiantDao etudiantDao;
    private OptionDao optionDao;
    public DefaultServices(){

    }

    public void setEtudiantDao(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    public void setOptionDao(OptionDao optionDao) {
        this.optionDao = optionDao;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantDao.addEtudiant(etudiant);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return etudiantDao.getEtudiants();
    }

    @Override
    public Option addOption(Option option) {
        return optionDao.addOption(option);
    }

    @Override
    public List<Option> getOptions() {
        return optionDao.getOptions();
    }
}
