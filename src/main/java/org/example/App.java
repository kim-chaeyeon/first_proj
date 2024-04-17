package org.example;

import org.example.controller.InformationController;
import org.example.controller.MemberController;
import org.example.controller.Controller;
import org.example.dto.Information;

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
            String[] cmdBits = cmd.split(" ");

            if ( cmdBits.length == 1 ) {
                System.out.println("존재하지 않는 명령어 입니다.");
                continue;
            }

            String controllerName = cmdBits[0];
            String actionMethodName = cmdBits[1];

            Controller controller = null;

            if (controllerName.equals("information")) {
                controller = informationController;
            } else if (controllerName.equals("member")) {
                controller = memberController;
        } else {
                System.out.println("존재하지 않는 명령어입니다.");
                continue;
            }

            String actionName = controllerName + "/" + actionMethodName;

            switch (actionName) {
                case "information/write":
                case "information/delete":
                case "information/modify":
                case "member/logout":
                    if (Controller.isLogined() == false) {
                        System.out.println("로그인 후 이용해주세요.");
                        continue;
                    }
                    break;
            }

            switch (actionName) {
                case "member/login":
                case  "member/join":
                    if (Controller.isLogined()) {
                        System.out.println("로그아웃 후 이용해주세요.");
                        continue;
                    }
                    break;
            }
            controller.doAction(cmd, actionMethodName);
        }
        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }
}