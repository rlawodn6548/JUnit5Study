package com.example.JavaTestApplication.mockito.verifying.order;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.List;

public class VerifyCallOrderTest {
    @Test
    void singleMockCallOrderVerifyTest() {
        // given
        List singleMock = Mockito.mock(List.class);
        singleMock.add("was added first");
        singleMock.add("was added second");

        // when
        InOrder inOrder = Mockito.inOrder(singleMock);

        // then
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");
    }

    @Test
    void multiMockCallOrderVerifyTest() {
        // given
        List firstMock = Mockito.mock(List.class);
        List secondMock = Mockito.mock(List.class);
        firstMock.add("was added first");
        secondMock.add("was added second");

        // when
        InOrder inOrder = Mockito.inOrder(firstMock, secondMock);

        // then
        inOrder.verify(firstMock).add("was added first");
        inOrder.verify(secondMock).add("was added second");
    }
}
