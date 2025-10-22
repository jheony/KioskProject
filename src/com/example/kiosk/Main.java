package com.example.kiosk;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner 선언
        Scanner scanner = new Scanner(System.in);
        boolean end = true;

        System.out.println("""
                [ SHAKESHACK MENU ]
                1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                0. 종료      | 종료""");

        while (end) {
            try {
                // 숫자 입력 받기
                String choice = scanner.nextLine();
                int choiceNum = Integer.parseInt(choice);

                // 입력된 숫자에 따른 처리
                switch (choiceNum) {
                    case 0:
                        end = false;
                        System.out.println("메뉴 선택을 종료합니다.");
                        break;
                    case 1:
                        System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                        break;
                    case 2:
                        System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                        break;
                    case 3:
                        System.out.println("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                        break;
                    case 4:
                        System.out.println("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                        break;
                    default:
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
