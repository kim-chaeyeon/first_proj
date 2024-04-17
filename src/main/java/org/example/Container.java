package org.example;

import org.example.dao.InformationDao;
import org.example.dao.MemberDao;
import org.example.service.InformationService;

public class Container {
    public static InformationDao informationDao;
    public static MemberDao memberDao;
    public static InformationService informationService;

    static {
        informationDao = new InformationDao();
        memberDao = new MemberDao();
        informationService = new InformationService();
    }
}