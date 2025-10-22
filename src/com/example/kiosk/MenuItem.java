package com.example.kiosk;

// 개별 음식 항목을 관리하는 클래스
public class MenuItem {
    // 속
    private String name;
    private double price;
    private String description;

    // 생
    // 메뉴의 이름, 가격, 설명 세팅
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 기
    // 메뉴의 (이름+가격+설명) 반환
    public String menuDescription(){
        return this.name +"\t\t| W " + this.price + "\t| "+this.description;
    }

}
