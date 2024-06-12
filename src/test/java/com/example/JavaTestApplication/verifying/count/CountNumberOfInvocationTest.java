package com.example.JavaTestApplication.verifying.count;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CountNumberOfInvocationTest {

    @Test
    void verifyTest() {
        // given
        ArrayList mockedList = Mockito.mock(ArrayList.class);

        // when
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        // then
        // mockedList.add("once")를 한 번 호출했는지 검사
        Mockito.verify(mockedList).add("once");
        Mockito.verify(mockedList, Mockito.times(1)).add("once");

        // mockedList.add("twice")를 두 번 호출했는지 검사
        Mockito.verify(mockedList, Mockito.times(2)).add("twice");

        // mockedList.add("three times")를 세 번 호출했는지 검사
        Mockito.verify(mockedList, Mockito.times(3)).add("three times");

        // mockedList.add("never")를 호출안했는지 검사
        Mockito.verify(mockedList, Mockito.never()).add("never");

        // 적어도 몇 번 또는 최대 몇 번 호출했는지 검사
        Mockito.verify(mockedList, Mockito.atMostOnce()).add("once");
        Mockito.verify(mockedList, Mockito.atLeastOnce()).add("twice");
        Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");
        Mockito.verify(mockedList, Mockito.atLeast(2)).add("three times");

    }
}
