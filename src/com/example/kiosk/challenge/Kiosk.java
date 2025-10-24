package com.example.kiosk.challenge;

import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속
    private final List<Menu> menuList;

    // 생
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // 기
    public void start() {

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        // 0이 들어오면 true로 설정하여 반복문 종료
        boolean isRunning = true;

        // 반복문 시작
        while (isRunning) {

            // 메인 메뉴 출력
            showMenu();

            try {
                // 숫자 입력 받기
                String choice = scanner.nextLine();
                int choiceNum = Integer.parseInt(choice);

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // 입력된 숫자에 따른 처리
                if (choiceNum == 0) {
                    // 프로그램 종료
                    isRunning = false;
                    System.out.println("메뉴 선택을 종료합니다.");
                } else if (0 < choiceNum && choiceNum <= menuList.size()) {
                    // 선택한 카테고리 메뉴 가져오기
                    Menu choiceMenu = menuList.get(choiceNum - 1);

                    // 메뉴판 출력
                    choiceMenu.showMenuItems();
                    System.out.println("0. 뒤로가기");

                    // 0번 뒤로가기 체크
                    boolean isInMenu = true;
                    while (isInMenu) {
                        try {
                            // 숫자 입력 받기
                            choice = scanner.nextLine();
                            choiceNum = Integer.parseInt(choice);

                            // 입력된 숫자에 따른 처리
                            if (choiceNum == 0) {
                                isInMenu = false;
                                System.out.println("메인 메뉴로 돌아갑니다.\n");
                            } else if (0 < choiceNum && choiceNum <= choiceMenu.getMenuItemsSize()) {
                                // 유효한 메뉴 번호라면 메뉴아이템 출력
                                System.out.println("선택한 메뉴: "
                                        + choiceMenu.getMenuItem(choiceNum - 1).menuDescription());
                            } else {
                                // 입력 오류
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("메뉴에 있는 번호를 입력해주세요.");
                        }
                    }
                } else {
                    // 입력 오류
                    throw new Exception();
                }
            } catch (Exception e) {
                // 예외 메세지 출력
                System.out.println("메뉴에 있는 번호를 입력해주세요.");
            }
        }
    }

    // 메인메뉴판 출력
    public void showMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
        }
        System.out.println("0. 종료\t\t| 종료");
    }
}