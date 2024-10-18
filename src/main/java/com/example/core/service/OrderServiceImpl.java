package com.example.core.service;

import com.example.core.entity.DiscountPolicy;
import com.example.core.entity.FixDiscountPolicy;
import com.example.core.entity.Member;
import com.example.core.entity.Order;
import com.example.core.repository.MemberRepository;
import com.example.core.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();

    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
