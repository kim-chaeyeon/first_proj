package org.example;

import org.example.dao.InformationDao;
import org.example.dao.MemberDao;

public class Container {
    public static InformationDao informationDao;
    public static MemberDao memberDao;

    static {
        informationDao = new InformationDao();
        memberDao = new MemberDao();
    }
}