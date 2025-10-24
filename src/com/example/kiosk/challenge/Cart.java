package com.example.kiosk.challenge;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // 속
    private final Map<MenuItem, Integer> items = new HashMap<>();

    // 생

    // 기
    // 장바구니에 물품 추가
    public void addItem(MenuItem menuItem) {

        // 장바구니에 해당 물품이 있는지 검사
        if (items.containsKey(menuItem)) {

            // 있다면 물품 수량 증가
            int quantity = items.get(menuItem);
            items.replace(menuItem, quantity + 1);
        } else {
            // 없다면 물품 추가
            items.put(menuItem, 1);
        }
        System.out.println(menuItem.getName() + " 이(가) 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 출력
    public void showCartItems() {
        // 물품 유무 검사
        if (isInItem()) {
            System.out.println("\n[ Orders ]");

            // 물품 출력
            for (MenuItem item : items.keySet()) {
                int quantity = items.get(item); // 물품 수량
                System.out.println("수량: " + quantity + " \t| " + item.menuDescription());
            }
        }
    }

    // 총 금액 반환
    public double totalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items.keySet()) {
            int quantity = items.get(item); // 물품 수량
            totalPrice += item.getPrice() * quantity;
        }
        return totalPrice;
    }

    // 장바구니에 물품이 있다면 true
    public boolean isInItem() {
        return !this.items.isEmpty();
    }
}