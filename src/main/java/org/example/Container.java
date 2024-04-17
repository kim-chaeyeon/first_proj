package org.example;

import org.example.dao.InformationDao;
import org.example.dao.MemberDao;
import org.example.service.InformationService;
import org.example.service.MemberService;

public class Container {
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
}