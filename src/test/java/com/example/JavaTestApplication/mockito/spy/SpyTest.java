package com.example.JavaTestApplication.mockito.spy;

import com.example.JavaTestApplication.mockito.mock.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Spy
    private TestService testService = new TestService("testName", 10);

    @Test
    void spyTest() {
        // given
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < 10; i++) {
            builder.append(testService.getName()).append(" ");
        }
        String expected = builder.substring(0, builder.length()-1);
        // when

        // then
        Assertions.assertEquals("testName", testService.getName());
        Assertions.assertEquals(10, testService.getNumber());
        Assertions.assertEquals(expected, testService.getNameTimes());
    }

    @Test
    @DisplayName("Spy Mock 객체에 대한 Stubbing 테스트")
    @Description("testService.getName() 호출 시 testName 대신 spyMockName 반환" +
            "testService.getNumber() 호출 시 10 대신 3 반환" +
            "testService.getNameTimes() 호출 시 원래 메소드 수행")
    void spyStubbingTest() {
        // given
        Mockito.when(testService.getName()).thenReturn("spyMockName");
        Mockito.when(testService.getNumber()).thenReturn(3);

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < 10; i++) {
            builder.append("testName").append(" ");
        }
        String expected = builder.substring(0, builder.length()-1);

        // when

        // then
        Assertions.assertEquals("spyMockName", testService.getName());
        Assertions.assertEquals(3, testService.getNumber());
        Assertions.assertEquals(expected, testService.getNameTimes());
    }
}
