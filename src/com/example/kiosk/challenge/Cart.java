package com.example.kiosk.challenge;

import java.util.HashMap;
import java.util.Map;

public class Cart{
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
    public boolean isInItem(){
        return !this.items.isEmpty();
    }

    // 할인된 가격 반환
    public double discountTotalPrice(int choiceNum) {
        double totalPrice = this.totalPrice();
        int discountRate = DiscountType.values()[choiceNum - 1].getDiscountRate();
        totalPrice -= totalPrice * (discountRate / 100.0);
        return totalPrice;
    }

    // 특정 메뉴아이템 제거
    public void removeMenuItem(String removeMenuItemName){
        // 물품명으로 장바구니에서 해당 물품 찾기
        MenuItem menuItem = items.keySet().stream()
                .filter(item -> item.getName().equals(removeMenuItemName))
                .findFirst().orElseThrow();

        int quantity = items.get(menuItem);

        // 수량이 1이면 메뉴 삭제
        if(quantity == 1){
            items.remove(menuItem);
        }
        // 수량이 2 이상이면 1감소
        else{
            items.put(menuItem, quantity-1);
        }
    }
}