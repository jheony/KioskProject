package com.example.kiosk.basic;

import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리하는 클래스
//  버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {
    // 속
    private String category;
    private List<MenuItem> menuItems = new ArrayList<>();

    // 생
    public Menu(String category) {
        this.category = category;
    }

    // 기
    // 카테고리 명을 반환합니다.
    public String getCategory() {
        return this.category;
    }

    // 메뉴아이템의 갯수를 반환합니다.
    public int getMenuItemsSize(){
        return this.menuItems.size();
    }

    // 원하는 메뉴아이템을 반환합니다.
    public MenuItem getMenuItem(int idx){
        return menuItems.get(idx);
    }

    // 메뉴아이템을 추가합니다.
    public void addMenuItem(String name, double price, String description){
        menuItems.add(new MenuItem(name, price, description));
    }

    // 메뉴아이템의 메뉴판을 출력합니다.
    public void showMenuItems() {
        int i=0;
        System.out.println("\n[ " + this.category.toUpperCase() + " ]");
        for (MenuItem menuItem : menuItems) {
            System.out.println(++i +". "+menuItem.menuDescription());
        }
    }
}
