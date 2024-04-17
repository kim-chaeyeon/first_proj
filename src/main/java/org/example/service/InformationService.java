package org.example.service;

import org.example.Container;
import org.example.dao.InformationDao;
import org.example.dto.Information;

import java.util.ArrayList;
import java.util.List;

public class InformationService {
    private InformationDao informationDao;

    public InformationService() {
        informationDao = Container.informationDao;
    }

    public List<Information> getForPrintInformations(String searchKeyword) {
        return informationDao.getForPrintInformations(searchKeyword);
    }

    public Information getInformationById(int id) {
        return informationDao.getInformationById(id);
    }

    public void remove(Information foundInformation) {
        informationDao.remove(foundInformation);
    }

    public void write(Information information) {
        informationDao.write(information);
    }
}