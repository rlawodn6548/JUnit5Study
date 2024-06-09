package com.example.JavaTestApplication.mockito.study;

import com.example.JavaTestApplication.mockito.MemberService;
import com.example.JavaTestApplication.mockito.domain.Member;
import com.example.JavaTestApplication.mockito.domain.Study;

import java.util.Optional;

public class StudyService {
    private final MemberService memberService;
    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        if (member.isPresent()) {
            study.setOwnerId(memberId);
        } else {
            throw new IllegalArgumentException("Member doesn't exist for id: " + memberId);
        }
        Study newStudy = studyRepository.save(study);
        memberService.notify(newStudy);
        return newStudy;
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = studyRepository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }
}
