package com.example.kiosk.challenge;

public enum DiscountType {
    VETERAN("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);

    private final String userType;
    private final int discountRate;

    DiscountType(String userType, int discountRate) {
        this.userType = userType;
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return this.discountRate;
    }

    public String getUserType() {
        return this.userType;
    }

}
