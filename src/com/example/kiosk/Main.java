package com.example.kiosk;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        // (add 보다 더 좋은 방법이 있다면 그렇게 해도 됩니다!) - ???? 뭘까요
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).menuDescription());
        }
        System.out.println("0. 종료\t\t| 종료");

        // 0이 들어오면 false로 반복문 종료
        boolean end = true;

        while (end) {
            try {
                // 숫자 입력 받기
                String choice = scanner.nextLine();
                int choiceNum = Integer.parseInt(choice);

                // 입력된 숫자에 따른 처리
                if (choiceNum == 0) {
                    // 프로그램 종료
                    end = false;
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
        System.out.println("프로그램을 종료합니다.");
    }
}
