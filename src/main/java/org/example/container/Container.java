package org.example.container;

import org.example.dao.InformationDao;
import org.example.dao.MemberDao;
import org.example.service.InformationService;
import org.example.service.MemberService;
import org.example.controller.Session;

public class Container {
    public static Session session;
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
        if ( session == null ) {
            session = new Session();
        }

        return session;
    }
}