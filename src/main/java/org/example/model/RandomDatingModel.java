package org.example.model;

import org.example.container.Container;
import org.example.dao.InformationDao;
import org.example.dto.Information;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomDatingModel {
    private InformationDao informationDao;

    public RandomDatingModel() {
        informationDao = Container.getInformationDao();
    }

    public Information getRandomMaleCandidate() {
        List<Information> maleCandidates = informationDao.getInformationsBySex("남자");
        return getRandomCandidate(maleCandidates);
    }

    public Information getRandomFemaleCandidate() {
        List<Information> femaleCandidates = informationDao.getInformationsBySex("여자");
        return getRandomCandidate(femaleCandidates);
    }

    private Information getRandomCandidate(List<Information> candidates) {
        if (candidates.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(candidates.size());
        return candidates.get(randomIndex);
    }

    public void deleteCandidate(Information candidate) {
        if (candidate != null) {
            informationDao.deleteInformation(candidate.getId());
        }
    }
}