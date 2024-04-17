package org.example.dao;

import org.example.Container;
import org.example.dto.Information;

import java.util.ArrayList;
import java.util.List;

public class InformationDao extends Dao {
    private List<Information> informations;

    public InformationDao() {
        informations = new ArrayList<>();
    }

    public void write(Information information) {
        informations.add(information);
        lastId = information.id;
    }
    private int getInformationIndexById(int id) {
        int i = 0;

        for (Information information : informations) {
            if (information.id == id) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public Information getInformationById(int id) {
        int index = getInformationIndexById(id);

        if (index != -1) {
            return informations.get(index);
        }

        return null;
    }

    public List<Information> getForPrintInformations(String searchKeyword) {
        if (searchKeyword != null && searchKeyword.length() != 0) {
            List<Information> forListInformations = new ArrayList<>();

            for (Information information : informations) {
                if (information.name.contains(searchKeyword)) {
                    forListInformations.add(information);
                }
            }

            return forListInformations;
        }

        return informations;
    }

    public void remove(Information foundInformation) {
        informations.remove(foundInformation);
    }
}
