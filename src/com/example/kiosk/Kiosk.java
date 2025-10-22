package com.example.kiosk;

import java.util.*;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속
    private List<MenuItem> menuItems;

    // 생
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    // 기
    public void start() {

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).menuDescription());
        }
        System.out.println("0. 종료\t\t| 종료");

        // 0이 들어오면 false로 반복문 종료
        boolean orderEnd = false;

        while (orderEnd == false) {
            try {
                // 숫자 입력 받기
                String choice = scanner.nextLine();
                int choiceNum = Integer.parseInt(choice);

                // 입력된 숫자에 따른 처리
                if (choiceNum == 0) {
                    // 프로그램 종료
                    orderEnd = true;
                    System.out.println("메뉴 선택을 종료합니다.");
                } else if (0 < choiceNum && choiceNum <= menuItems.size()) {
                    // 선택한 메뉴 : 이름, 가격, 설명
                    System.out.println(menuItems.get(choiceNum - 1).menuDescription());
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                // 예외 메세지 출력
                System.out.println("메뉴에 있는 번호를 입력해주세요.");
            }
        }
    }
}
