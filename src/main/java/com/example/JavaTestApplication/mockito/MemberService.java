package com.example.JavaTestApplication.mockito;


import com.example.JavaTestApplication.mockito.domain.Member;
import com.example.JavaTestApplication.mockito.domain.Study;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId);
    void validate(Long memberId);
    void notify(Study newstudy);
    void notify(Member member);
}
