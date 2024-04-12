package org.example;

import org.example.controller.InformationController;
import org.example.controller.MemberController;
import org.example.dto.Information;
import org.example.dto.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Information> informations;

    App() {
        informations = new ArrayList<>();
    }

    public void start() {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);

        MemberController memberController = new MemberController(sc);
        InformationController informationController = new InformationController(sc);

        int lastInformationId = 0;

        while (true) {
            System.out.printf("명령어) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("exit")) {
                break;
            }

            if ( cmd.equals("member join") ) {
                memberController.doJoin();
            }

            else if (cmd.equals("information write")) {


            } else if (cmd.equals("information list")) {


            } else if (cmd.startsWith("information detail ")) {

            } else if (cmd.startsWith("information delete ")) {

            } else if (cmd.startsWith("information modify ")) {

            } else {
                System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", cmd);
            }
        }
        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }
}