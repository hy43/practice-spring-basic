package com.example.core.entity;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (isVip(member)) {
            return price * discountPercent / 100;
        }
        return 0;
    }

    private static boolean isVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }
}
