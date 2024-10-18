package com.example.core.service;

import com.example.core.entity.Grade;
import com.example.core.entity.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member joinMember = new Member(1L, "member1", Grade.VIP);

        // when
        memberService.join(joinMember);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(joinMember.getName()).isEqualTo(findMember.getName());
    }
}
