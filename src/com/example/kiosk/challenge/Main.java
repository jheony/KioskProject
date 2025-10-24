//  도전과제 lv1 목표
//  클래스 간 역할 분리를 이해하고, 적절히 협력하는 객체를 설계
//  프로그램 상태 변경 및 데이터 저장을 연습
//  사용자 입력에 따른 예외 처리와 조건 분기를 연습

package com.example.kiosk.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menuList = new ArrayList<>();

        // Menu 객체 생성을 통해 category 설정
        Menu burgers = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        // 메뉴아이템 추가
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        burgers.addMenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.addMenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        drinks.addMenuItem("사이다", 2.0, "500ml");
        drinks.addMenuItem("환타", 1.5, "파인애플");
        drinks.addMenuItem("콜라", 2.0, "355ml");
        drinks.addMenuItem("펩시제로", 3.0, "355ml");

        desserts.addMenuItem("에그타르트", 3.5, "파삭 달다구리");
        desserts.addMenuItem("아이스크림", 2.0, "소프트");
        desserts.addMenuItem("치즈스틱", 2.5, "쭈우우우우욱");
        desserts.addMenuItem("감자튀김", 5.0, "눅눅");

        // 메뉴 추가
        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);

        // Kiosk 객체 생성을 통해 menuList 넘기기
        Kiosk kiosk = new Kiosk(menuList);

        // 메뉴 선택 시작
        kiosk.start();
        System.out.println("프로그램을 종료합니다.");
    }
}