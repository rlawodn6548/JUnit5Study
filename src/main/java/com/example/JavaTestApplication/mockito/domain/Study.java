package com.example.JavaTestApplication.mockito.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class Study {
    private Long id;
    private StudyStatus status = StudyStatus.DRAFT;
    private int limitCount;
    private String name;
    private LocalDateTime openedDateTime;
    private Long ownerId;

    public Study(int limit, String name) {
        this.limitCount = limit;
        this.name = name;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must greater than 0");
        }
        this.limitCount = limit;
    }

    public void open() {
        this.openedDateTime = LocalDateTime.now();
        this.status = StudyStatus.OPENED;
    }
}
