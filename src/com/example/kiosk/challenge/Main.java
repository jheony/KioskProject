//  도전과제 lv1 목표
//  클래스 간 역할 분리를 이해하고, 적절히 협력하는 객체를 설계
//  프로그램 상태 변경 및 데이터 저장을 연습
//  사용자 입력에 따른 예외 처리와 조건 분기를 연습

package com.example.kiosk.challenge;

import com.example.kiosk.challenge.food.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu<? extends MenuItem>> menuList = new ArrayList<>();

        // Menu 객체 생성을 통해 category 설정
        Menu<BurgerItem> burgers = new Menu<>("burgers");
        Menu<DrinkItem> drinks = new Menu<>("Drinks");
        Menu<DessertItem> desserts = new Menu<>("Desserts");

        // 메뉴아이템 추가
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        burgers.addMenuItem(new BurgerItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new BurgerItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new BurgerItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new BurgerItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinks.addMenuItem(new DrinkItem("사이다", 2.0, "500ml"));
        drinks.addMenuItem(new DrinkItem("환타", 1.5, "파인애플"));
        drinks.addMenuItem(new DrinkItem("콜라", 2.0, "355ml"));
        drinks.addMenuItem(new DrinkItem("펩시제로", 3.0, "355ml"));

        desserts.addMenuItem(new DessertItem("에그타르트", 3.5, "파삭 달다구리"));
        desserts.addMenuItem(new DessertItem("아이스크림", 2.0, "소프트"));
        desserts.addMenuItem(new DessertItem("치즈스틱", 2.5, "쭈우우우우욱"));
        desserts.addMenuItem(new DessertItem("감자튀김", 5.0, "눅눅"));

        // 메뉴 추가
        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);

        // Kiosk 객체 생성을 통해 menuList 넘기기
        Kiosk kiosk = new Kiosk(menuList);

        // 메뉴 선택 시작
        kiosk.start();
    }
}
