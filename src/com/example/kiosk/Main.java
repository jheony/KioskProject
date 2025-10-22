package com.example.kiosk;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Menu> menuList = new ArrayList<>();

        // Menu 객체 생성을 통해 category 설정
        menuList.add(new Menu("Burgers"));
        menuList.add(new Menu("Drinks"));
        menuList.add(new Menu("Desserts"));

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        //TODO: (add 보다 더 좋은 방법이 있다면 그렇게 해도 됩니다!) - MenuList 내에 add 함수 구현
        menuList.get(0).menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.get(0).menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.get(0).menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.get(0).menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        menuList.get(1).menuItems.add(new MenuItem("사이다", 2.0, "500ml"));
        menuList.get(1).menuItems.add(new MenuItem("환타", 1.5, "파인애플"));
        menuList.get(1).menuItems.add(new MenuItem("콜라", 2.0, "355ml"));
        menuList.get(1).menuItems.add(new MenuItem("펩시제로", 3.0, "355ml"));

        menuList.get(2).menuItems.add(new MenuItem("에그타르트", 3.5, "파삭 달다구리"));
        menuList.get(2).menuItems.add(new MenuItem("아이스크림", 2.0, "소프트"));
        menuList.get(2).menuItems.add(new MenuItem("치즈스틱", 2.5, "쭈우우우우욱"));
        menuList.get(2).menuItems.add(new MenuItem("감자튀김", 5.0, "눅눅"));

        // Kiosk 객체 생성을 통해 menuList 넘기기
        Kiosk kiosk = new Kiosk(menuList);

        // 메뉴 선택 시작
        kiosk.start();
        System.out.println("프로그램을 종료합니다.");
    }
}
