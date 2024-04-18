package org.example.controller;

import org.example.container.Container;
import org.example.dto.Information;
import org.example.dto.Member;
import org.example.service.InformationService;
import org.example.service.MemberService;
import org.example.util.Util;

import java.util.List;
import java.util.Scanner;

public class InformationController extends Controller{
    private Scanner sc;
    private String cmd;
    private String actionMethodName;
    private InformationService informationService;
    private MemberService memberService;
    private Session session;

    public InformationController(Scanner sc) {
        this.sc = sc;
        informationService = Container.informationService;
        memberService = Container.memberService;
        session = Container.getSession();
    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
        this.actionMethodName = actionMethodName;

        switch (actionMethodName) {
            case "write":
                doWrite();
                break;
            case "list":
                showList();
                break;
            case "detail":
                showDetail();
                break;
            case "modify":
                doModify();
                break;
            case "delete":
                doDelete();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }
    }

    public void doWrite(){
        int id = Container.informationDao.getNewId();
        String regDate = Util.getNowDateStr();
        System.out.printf("이름 : ");
        String name = sc.nextLine();
        System.out.printf("성별 : ");
        String sex = sc.nextLine();
        System.out.printf("나이 : ");
        String age = sc.nextLine();
        System.out.printf("학과 : ");
        String major = sc.nextLine();
        System.out.printf("전화번호 : ");
        String phoneNumber = sc.nextLine();
        System.out.printf("MBTI : ");
        String mbti = sc.nextLine();
        System.out.printf("인스타 아이디 : ");
        String snsId = sc.nextLine();
        System.out.printf("매력어필 : ");
        String appeal = sc.nextLine();

        Member loginedMember = session.getLoginedMember();
        Information information = new Information(id, regDate, loginedMember.id, name, sex, age, major, phoneNumber, mbti, snsId, appeal);
        informationService.write(information);

        System.out.printf("%d번 정보가 생성되었습니다.\n", id);
    }
    public void showList() {

        String searchKeyword = cmd.substring("information list".length()).trim();

        List<Information> forPrintInformations = informationService.getForPrintInformations(searchKeyword);

        if (forPrintInformations.size() == 0) {
            System.out.println("검색결과가 존재하지 않습니다.");
            return;
        }

        System.out.println("번호 |  작성자 | 이름 | 성별 | 나이 | 학과 | 전화번호 | MBTI | 인스타 아이디 | 매력어필");
        for (int i = forPrintInformations.size() - 1; i >= 0; i--) {
            Information information = forPrintInformations.get(i);
            String writerName = null;

            List<Member> members = Container.memberDao.members;

            for ( Member member : members ) {
                if ( information.memberId == member.id ) {
                    writerName = member.name;
                    break;
                }
            }

            System.out.printf("%d | %d | %s | %s | %s | %s | %s | %s | %s | %s\n",
                    information.id, information.memberId,information.name, information.sex, information.age,
                    information.major, information.phoneNumber, information.mbti,
                    information.snsId, information.appeal);
        }
    }
    public void  showDetail() {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]); // "1" => 1

        Information foundInformation = informationService.getInformationById(id);

        if (foundInformation == null) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("번호 : %d\n", foundInformation.id);
        System.out.printf("날짜 : %s\n", foundInformation.regDate);
        System.out.printf("작성자 : %d\n", foundInformation.memberId);
        System.out.printf("이름 : %s\n", foundInformation.name);
        System.out.printf("나이 : %s\n", foundInformation.age);
        System.out.printf("학과 : %s\n", foundInformation.major);
        System.out.printf("전화번호 : %s\n", foundInformation.phoneNumber);
        System.out.printf("MBTI : %s\n", foundInformation.mbti);
        System.out.printf("인스타 아이디 : %s\n", foundInformation.snsId);
        System.out.printf("매력어필 : %s\n", foundInformation.appeal);
    }
    public void doModify(){
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]);

        Information foundInformation = informationService.getInformationById(id);

        if (foundInformation == null) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
            return;
        }

        Member loginedMember = session.getLoginedMember();

        if ( foundInformation.memberId != loginedMember.id ) {
            System.out.printf("권한이 없습니다.\n");
            return;
        }

        System.out.printf("이름 : ");
        String name = sc.nextLine();
        System.out.printf("성별 : ");
        String sex = sc.nextLine();
        System.out.printf("나이 : ");
        String age = sc.nextLine();
        System.out.printf("학과 : ");
        String major = sc.nextLine();
        System.out.printf("전화번호 : ");
        String phoneNumber = sc.nextLine();
        System.out.printf("MBTI : ");
        String mbti = sc.nextLine();
        System.out.printf("인스타 아이디 : ");
        String snsId = sc.nextLine();
        System.out.printf("매력어필 : ");
        String appeal = sc.nextLine();

        foundInformation.name = name;
        foundInformation.sex = sex;
        foundInformation.age = age;
        foundInformation.major = major;
        foundInformation.phoneNumber = phoneNumber;
        foundInformation.mbti = mbti;
        foundInformation.snsId = snsId;
        foundInformation.appeal = appeal;

        System.out.printf("%d번 정보가 수정되었습니다.\n", id);
    }
    public void doDelete() {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]);

        Information foundInformation = informationService.getInformationById(id);

        if (foundInformation == null) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
            return;
        }

        Member loginedMember = session.getLoginedMember();

        if ( foundInformation.memberId != loginedMember.id ) {
            System.out.printf("권한이 없습니다.\n");
            return;
        }

        informationService.remove(foundInformation);

        System.out.printf("%d번 정보가 삭제되었습니다.\n", id);
    }
}