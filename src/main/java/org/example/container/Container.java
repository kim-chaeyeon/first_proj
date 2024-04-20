package org.example.container;

import org.example.dao.InformationDao;
import org.example.dao.MemberDao;
import org.example.db.DBConnection;
import org.example.service.InformationService;
import org.example.service.MemberService;
import org.example.controller.Session;

public class Container {
    public static Session session;
    public static DBConnection dbConnection;
    public static InformationDao informationDao;
    public static MemberDao memberDao;
    public static InformationService informationService;
    public static MemberService memberService;

    static {
        informationDao = new InformationDao();
        memberDao = new MemberDao();
        informationService = new InformationService();
        memberService = new MemberService();
    }

    public static Session getSession() {
        if (session == null) {
            session = new Session();
        }

        return session;
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public static InformationDao getInformationDao() {
        if (informationDao == null) {
            informationDao = new InformationDao();
        }

        return informationDao;
    }

    public static MemberDao getMemberDao() {
        if (memberDao == null) {
            memberDao = new MemberDao();
        }

        return memberDao;
    }

}
