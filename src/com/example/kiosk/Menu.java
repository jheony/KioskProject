package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리하는 클래스
public class Menu {
    //  버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
    // 속
    String category;
    List<MenuItem> menuItems = new ArrayList<>();

    // 생
    public Menu(String category) {
        this.category = category;
    }

    // 기
    public String getCategory() {
        return category;
    }

    public void showMenuItems() {
        System.out.println("\n[ " + this.category.toUpperCase() + " ]");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.name);
        }
    }
}
