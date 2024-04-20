package org.example;

import org.example.controller.InformationController;
import org.example.controller.MemberController;
import org.example.controller.Controller;
import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Information;
import org.example.model.RandomDatingModel;

import java.util.Scanner;

public class App {
    public App() {
        DBConnection.DB_NAME = "first_proj";
        DBConnection.DB_USER = "sbsst";
        DBConnection.DB_PASSWORD = "sbs123414";
        DBConnection.DB_PORT = 3306;

        Container.getDBConnection().connect();
    }

    public void start() {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);

        MemberController memberController = new MemberController(sc);
        InformationController informationController = new InformationController(sc);
        RandomDatingModel randomDatingModel = new RandomDatingModel();

        // 회원가입
        System.out.println("회원가입 해주세요.");
        memberController.doAction("member/join", "join");

        // 로그인
        System.out.println("로그인 후 이용이 가능합니다.");
        memberController.doAction("member/login", "login");

        // 개인 정보 입력
        if (Container.getSession().isLogined()) {
            System.out.println("개인 정보를 입력해주세요.(입력하신 개인정보는 다른사람에게 전달됩니다.)");
            informationController.doAction("information/write", "write");
        } else {
            System.out.println("로그인이 필요합니다. 프로그램을 종료합니다.");
            sc.close();
            return;
        }

        int lastInformationId = 0;

        while (true) {
            System.out.printf("[번호로 입력주세요 ex) 선택: 1]\n1. 남자\n2. 여자\n3. 명령어 입력\n(내 정보 확인: information list / 정보 수정: information/modify / 정보 삭제: information/delete / 로그아웃: member/logout)\n선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    Information maleCandidate = randomDatingModel.getRandomMaleCandidate();
                    if (maleCandidate != null) {
                        System.out.println("선택된 남자 정보: " + maleCandidate.getInformation());
                        randomDatingModel.deleteCandidate(maleCandidate); // 후보자 정보 삭제
                        MemberController.doLogout(); // 뽑기 후 자동 로그아웃
                        sc.close();
                        System.out.println("== 뽑기 후 프로그램 종료 (메일로 남자의 정보를 보냈습니다) ==");
                        return; // 프로그램 종료
                    } else {
                        System.out.println("남자 후보자가 없습니다.");
                    }
                    break;
                case "2":
                    Information femaleCandidate = randomDatingModel.getRandomFemaleCandidate();
                    if (femaleCandidate != null) {
                        System.out.println("선택된 여자 정보: \n" + femaleCandidate.getInformation());
                        randomDatingModel.deleteCandidate(femaleCandidate); // 후보자 정보 삭제
                        MemberController.doLogout(); // 뽑기 후 자동 로그아웃
                        sc.close();
                        System.out.println("== 뽑기 후 프로그램 종료 (메일로 여자의 정보를 보냈습니다) ==");
                        return; // 프로그램 종료
                    } else {
                        System.out.println("여자 후보자가 없습니다.");
                    }
                    break;
                case "3":
                    System.out.printf("명령어 입력: ");
                    String cmd = sc.nextLine().trim();

                    // 명령어 처리
                    String[] cmdBits = cmd.split(" ");
                    if (cmdBits.length < 2) {
                        System.out.println("잘못된 명령어 형식입니다.");
                        break;
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
                        break;
                    }

                    String actionName = controllerName + "/" + actionMethodName;

                    switch (actionName) {
                        case "information/list":
                        case "information/delete":
                        case "information/modify":
                        case "member/logout":
                            if (!Container.getSession().isLogined()) {
                                System.out.println("로그인 후 이용해주세요.");
                                break;
                            }
                            break;
                        case "member/login":
                        case "member/join":
                            if (Container.getSession().isLogined()) {
                                System.out.println("로그아웃 후 이용해주세요.");
                                break;
                            }
                            break;
                    }
                    controller.doAction(cmd, actionMethodName);
                    break;
                default:
                    System.out.println("올바른 선택지를 입력하세요.");
            }
        }
    }
}
