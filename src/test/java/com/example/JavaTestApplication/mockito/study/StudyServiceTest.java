package com.example.JavaTestApplication.mockito.study;

import com.example.JavaTestApplication.mockito.MemberService;
import com.example.JavaTestApplication.mockito.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    private MemberService memberService;
    @Mock
    private StudyRepository studyRepository;

    @Test
    @DisplayName("Mock 객체 만들기")
    void createStudyService() {
        MemberService memberService = Mockito.mock(MemberService.class);
        StudyRepository studyRepository = Mockito.mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);

        Assertions.assertNotNull(studyService);
    }

    @Test
    @DisplayName("Mock 객체 만들기2")
    void createStudyService2(@Mock MemberService memberService2, @Mock StudyRepository studyRepository2) {
        StudyService studyService = new StudyService(memberService2, studyRepository2);

        Assertions.assertNotNull(studyService);
    }

    @Test
    @DisplayName("여러 번 호출 시 다른 응답하는 Stubbing")
    void multiResponseStubbing(@Mock MemberService memberService) {
        // given
        when(memberService.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(new Member(1L, "first Response")))
                .thenThrow(new RuntimeException("second Response"))
                .thenReturn(Optional.of(new Member(3L, "third Response")));

        // when
        List<Member> answerMemberList = new ArrayList<>();
        for (int i=0 ; i<6; i++) {
            try {
                answerMemberList.add(memberService.findById(1L).get());
            } catch (Exception e) {
                answerMemberList.add(new Member(2L, "two Response"));
            }
        }

        // then
        Member expected1 = new Member(1L, "first Response");
        Member expected2 = new Member(2L, "two Response");
        Member expected3 = new Member(3L, "third Response");

        for (int i = 0; i<6; i++) {
            if (i == 0) {
                Assertions.assertEquals(expected1.getId(), answerMemberList.get(i).getId());
                Assertions.assertEquals(expected1.getEmail(), answerMemberList.get(i).getEmail());
            } else if (i == 1) {
                Assertions.assertEquals(expected2.getId(), answerMemberList.get(i).getId());
                Assertions.assertEquals(expected2.getEmail(), answerMemberList.get(i).getEmail());
            } else {
                Assertions.assertEquals(expected3.getId(), answerMemberList.get(i).getId());
                Assertions.assertEquals(expected3.getEmail(), answerMemberList.get(i).getEmail());
            }
        }

    }
}