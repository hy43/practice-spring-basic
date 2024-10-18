package com.example.core.service;

import com.example.core.entity.Member;
import com.example.core.repository.MemberRepository;
import com.example.core.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        repository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return repository.findById(memberId);
    }
}
