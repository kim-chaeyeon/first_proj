package org.example.controller;

import org.example.dto.Information;
import org.example.dto.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationController {
    private Scanner sc;
    private List<Information> informations;

    public InformationController(Scanner sc) {
        this.sc = sc;
        informations = new ArrayList<>();
    }
    public void doWrite(){
        int id = informations.size() + 1;
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

        Information information = new Information(id, regDate, name, sex, age, major, phoneNumber, mbti, snsId, appeal);
        informations.add(information);

        System.out.printf("%d번 정보가 생성되었습니다.\n", id);
    }
    public void showList(String cmd) {
        if (informations.size() == 0) {
            System.out.println("게시물이 없습니다.");
            return;
        }
        String searchKeyword = cmd.substring("information list".length()).trim();

        List<Information> forListInformation = informations;

        if (searchKeyword.length() > 0) {
            forListInformation = new ArrayList<>();

            for (Information information : informations) {
                if (information.name.contains(searchKeyword)) {
                    forListInformation.add(information);
                }
            }

            if (forListInformation.size() == 0) {
                System.out.println("검색결과가 존재하지 않습니다.");
                return;
            }
        }

        System.out.println("번호 | 이름 | 성별 | 나이 | 학과 | 전화번호 | MBTI | 인스타 아이디 | 매력어필");
        for (int i = informations.size() - 1; i >= 0; i--) {
            Information information = informations.get(i);

            System.out.printf("%d | %s | %s | %s | %s | %s | %s | %s | %s\n",
                    information.id, information.name, information.sex, information.age,
                    information.major, information.phoneNumber, information.mbti,
                    information.snsId, information.appeal);
        }
    }
    public void  showDetail(String cmd) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]); // "1" => 1

        Information foundInformation = getInformationById(id);

        if (foundInformation == null) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("번호 : %d\n", foundInformation.id);
        System.out.printf("날짜 : %s\n", foundInformation.regDate);
        System.out.printf("이름 : %s\n", foundInformation.name);
        System.out.printf("나이 : %s\n", foundInformation.age);
        System.out.printf("학과 : %s\n", foundInformation.major);
        System.out.printf("전화번호 : %s\n", foundInformation.phoneNumber);
        System.out.printf("MBTI : %s\n", foundInformation.mbti);
        System.out.printf("인스타 아이디 : %s\n", foundInformation.snsId);
        System.out.printf("매력어필 : %s\n", foundInformation.appeal);
    }
    public void doModify(String cmd){
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]);

        Information foundInformation = getInformationById(id);

        if (foundInformation == null) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
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
    public void doDelete(String cmd) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]);

        int foundIndex = getInformationIndexById(id);

        if (foundIndex == -1) {
            System.out.printf("%d번 정보는 존재하지 않습니다.\n", id);
            return;
        }

        // size() => 3
        // index : 0, 1, 2
        // id    : 1, 2, 3
        informations.remove(foundIndex);

        System.out.printf("%d번 정보가 삭제되었습니다.\n", id);
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

    private Information getInformationById(int id) {
        int index = getInformationIndexById(id);

        if (index != -1) {
            return informations.get(index);
        }

        return null;
    }
}