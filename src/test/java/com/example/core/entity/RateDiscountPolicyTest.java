package com.example.core.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy policy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP라면 10% 할인")
    void discountVip() {
        // given
        Member member = new Member(1L, "memberVip", Grade.VIP);

        // when
        int discountPrice = policy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니라면 0원 할인")
    void discountBasic() {
        // given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        // when
        int discountPrice = policy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(0);
    }
}