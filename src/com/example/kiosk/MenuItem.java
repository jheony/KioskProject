package com.example.kiosk;

// 세부 메뉴 속성을 가지는 클래스
public class MenuItem {
    // 속
    private String name;
    private double price;
    private String description;

    // 생
    // new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 기
    public String toString(){
        String menuDescription = this.name +"\t\t| W " + this.price + "\t| "+this.description;
        return menuDescription;
    }

}
