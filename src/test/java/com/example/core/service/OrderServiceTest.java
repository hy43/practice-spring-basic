package com.example.core.service;

import com.example.core.entity.Grade;
import com.example.core.entity.Member;
import com.example.core.entity.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrderWithVip() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        // when
        Order item = orderService.createOrder(memberId, "item1", 5000);

        // then
        assertThat(item.cacualtePrice()).isEqualTo(4000);
    }

    @Test
    void createOrderWithBasic() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.BASIC);
        memberService.join(member);

        // when
        Order item = orderService.createOrder(memberId, "item1", 5000);

        // then
        assertThat(item.cacualtePrice()).isEqualTo(5000);
    }
}
