package com.example.kiosk.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// MenuItem 클래스를 관리하는 클래스
//  버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu <T extends MenuItem> {
    // 속
    private final String category;
    private final List<T> menuItems = new ArrayList<>();

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
    public int getMenuItemsSize() {
        return this.menuItems.size();
    }

    // 원하는 메뉴아이템을 반환합니다.
    public T getMenuItem(int idx) {
        return menuItems.get(idx);
    }

    // 메뉴아이템을 추가합니다.
    public void addMenuItem(T menuItem) {
        menuItems.add(menuItem);
    }

    // 스트림을 활용한 메뉴아이템의 메뉴판 출력
    public void showMenuItems() {
        System.out.println("\n[ " + this.category.toUpperCase() + " ]");
        IntStream.range(0, this.menuItems.size())
                .forEach(i -> System.out.println(i+1 + ". " + this.menuItems.get(i).menuDescription()));
    }
}