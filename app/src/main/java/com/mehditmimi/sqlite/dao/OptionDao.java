package com.mehditmimi.sqlite.dao;

import com.mehditmimi.sqlite.beans.Etudiant;
import com.mehditmimi.sqlite.beans.Option;

import java.util.List;

public interface OptionDao {
    public Option addOption(Option option);
    public List<Option> getOptions();
}
