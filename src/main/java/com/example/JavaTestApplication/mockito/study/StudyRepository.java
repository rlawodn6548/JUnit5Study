package com.example.JavaTestApplication.mockito.study;

import com.example.JavaTestApplication.mockito.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
