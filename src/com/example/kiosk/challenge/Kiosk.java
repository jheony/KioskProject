package com.example.kiosk.challenge;

import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속
    private final List<Menu> menuList;
    private Cart cart = new Cart();

    // 생
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // 기
    public void start() {

        // 0이 들어오면 true로 설정하여 반복문 종료
        boolean isRunning = true;

        // 반복문 시작
        while (isRunning) {

            // 메인 메뉴 출력
            showMainMenu();

            if (cart.isInItem()) {
                showOrderMenu();
            }
            try {
                // 숫자 입력 받기
                System.out.print("메뉴를 선택하세요: ");
                int choiceNum = inputChoice();

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // 입력된 숫자에 따른 처리
                if (choiceNum == 0) {

                    // 프로그램 종료
                    isRunning = false;
                    System.out.println("프로그램을 종료합니다.");

                    // 장바구니 목록 출력
                    cart.showCartItems();

                    // 총 가격 출력
                    System.out.println("[ Total ]\nW " + cart.totalPrice());
                } else if (0 < choiceNum && choiceNum <= menuList.size()) {

                    // 선택한 카테고리 메뉴 가져오기
                    Menu choiceMenu = menuList.get(choiceNum - 1);

                    // 메뉴판 출력
                    choiceMenu.showMenuItems();
                    System.out.println("0. 뒤로가기");

                    // 0번 뒤로가기 체크
                    try {

                        // 카테고리 내 메뉴 입력 받기
                        choiceNum = inputChoice();

                        // 입력된 숫자에 따른 처리
                        if (choiceNum == 0) {
                            System.out.println("메인 메뉴로 돌아갑니다.\n");
                        } else if (0 < choiceNum && choiceNum <= choiceMenu.getMenuItemsSize()) {
                            MenuItem choiceMenuItem = choiceMenu.getMenuItem(choiceNum - 1);

                            // 유효한 메뉴 번호라면 메뉴아이템 출력
                            System.out.println("선택한 메뉴: " + choiceMenuItem.menuDescription());

                            // 장바구니에 추가 여부 질문
                            System.out.println("\n\"" + choiceMenuItem.menuDescription() + "\"");
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인\t\t\t2. 취소");

                            // 장바구니 추가 여부 입력 받기
                            choiceNum = inputChoice();

                            if (choiceNum == 1) {
                                // 장바구니에 추가
                                cart.addItem(choiceMenuItem);
                            }

                            System.out.println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");

                        } else {

                            // 입력 오류
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("메뉴에 있는 번호를 입력해주세요.");
                    }
                } else if (cart.isInItem() && choiceNum == 4) {
                    // Orders 선택
                    System.out.println("\n아래와 같이 주문 하시겠습니까?");
                    cart.showCartItems();
                    System.out.println("\n[ Total ]\nW " + cart.totalPrice());
                    System.out.println("\n1. 주문\t\t2. 메뉴판");

                    // 주문 여부 입력 받기
                    choiceNum = inputChoice();

                    if (choiceNum == 1) {
                        int idx = 0;
                        System.out.println("\n할인 정보를 입력해주세요.");
                        for (DiscountType discountType : DiscountType.values()) {
                            System.out.println(++idx + ". " + discountType.getUserType() + "\t\t: "
                                    + discountType.getDiscountRate() + "%");
                        }
                        // 할인 정보 입력 받기
                        choiceNum = inputChoice();
                        double totalPrice = discountTotalPrice(choiceNum);

                        System.out.printf("%n주문이 완료되었습니다. 금액은 W %.2f 입니다.%n", totalPrice);

                        // 주문 완료 후 장바구니 초기화
                        cart = new Cart();
                        isRunning = false;
                        System.out.println("프로그램을 종료합니다.");
                    }
                } else {

                    // 입력 오류
                    throw new Exception();
                }
            } catch (Exception e) {

                // 예외 메세지 출력
                System.out.println("메뉴에 있는 번호를 입력해주세요.");
            }
        }
    }

    // 메인메뉴판 출력
    public void showMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
        }
        System.out.println("0. 종료\t\t| 종료");
    }

    public void showOrderMenu() {
        System.out.println("""
                
                [ ORDER MENU ]
                4. Orders\t\t| 장바구니를 확인 후 주문합니다.
                5. Cancel\t\t| 진행중인 주문을 취소합니다.""");
    }

    // 숫자 입력 받기
    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        int num = Integer.parseInt(choice);

        return num;
    }

    // 할인된 가격 반환
    public double discountTotalPrice(int choiceNum) {
        double totalPrice = cart.totalPrice();
        int discountRate = DiscountType.values()[choiceNum - 1].getDiscountRate();
        totalPrice -= totalPrice / (100.0/discountRate);
        return totalPrice;
    }
}