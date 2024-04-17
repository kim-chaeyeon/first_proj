package org.example.dao;

import org.example.dto.Information;
import java.util.ArrayList;
import java.util.List;

public class InformationDao extends Dao {
    public List<Information> informations;

    public InformationDao() {
        informations = new ArrayList<>();
    }

    public void add(Information information) {
        informations.add(information);
        lastId++;
    }
}
