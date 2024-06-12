package com.example.JavaTestApplication.mockito.verifying.timeout;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class VerifyTimeoutTest {
    @Test
    void verifyTimeoutTest() {
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
        Mockito.verify(mockedList, Mockito.timeout(1000L).atLeast(2)).add("twice");
    }
}
