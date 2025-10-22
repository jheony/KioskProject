package com.example.kiosk;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        // (add 보다 더 좋은 방법이 있다면 그렇게 해도 됩니다!) - ???? 뭘까요
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk(menuItems);

        // 메뉴 선택 시작
        kiosk.start();
        System.out.println("프로그램을 종료합니다.");
    }
}
