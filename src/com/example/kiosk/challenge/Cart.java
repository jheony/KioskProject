package com.example.kiosk.challenge;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // 속
    private Map<MenuItem, Integer> items = new HashMap<>();

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

    // 장바구니에 물품이 있다면 true
    public boolean isInItem(){
        return !this.items.isEmpty();
    }
}