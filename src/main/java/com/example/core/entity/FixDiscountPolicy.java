package com.example.core.entity;

public class FixDiscountPolicy implements DiscountPolicy {

    private int fixDiscountAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (isVip(member)) {
            return fixDiscountAmount;
        }
        return 0;
    }

    private boolean isVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }
}
