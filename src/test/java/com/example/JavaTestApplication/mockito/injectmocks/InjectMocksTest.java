package com.example.JavaTestApplication.mockito.injectmocks;

import com.example.JavaTestApplication.mockito.mock.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

@ExtendWith(MockitoExtension.class)
public class InjectMocksTest {
    @Mock
    TestService testService;

    @InjectMocks
    WrappingTestService wrappingTestService = new WrappingTestService(new TestService("tet", 3), "dest");

    @Test
    @DisplayName("@InjectMocks 테스트")
    @Description("WrappingTestService의 TestService가 Mock으로 생성된 TestService와 동일한 객체인지 검사" +
            "@InjectMocks으로 생성된 객체는 Mock 객체가 아니라 실제 객체인 것을 검사")
    void injectMocksTest() {
        // given
        // when

        // then
        Assertions.assertSame(testService, wrappingTestService.getTestService());
        Assertions.assertNull(wrappingTestService.getTestService().getName());
        Assertions.assertEquals(0, wrappingTestService.getTestService().getNumber());
        Assertions.assertNull(wrappingTestService.getTestService().getNameTimes());
        Assertions.assertEquals("dest", wrappingTestService.getWrappingDes());
    }

    @Test
    @DisplayName("@InjectMocks stubbing 테스트")
    void injectMocksStubbingTest() {
        // given
        Mockito.when(testService.getName()).thenReturn("mockName");
        // when

        // then
        Assertions.assertSame(testService, wrappingTestService.getTestService());
        Assertions.assertEquals(testService.getName(), wrappingTestService.getTestService().getName());
        Assertions.assertEquals("dest", wrappingTestService.getWrappingDes());
    }

    @Test
    @DisplayName("@InjectMocks 객체 Stubbing 에러 테스트")
    @Description("@InjectMocks로 생성한 객체에 Stubbing을 했을 경우 Exception이 발생하는지 검사")
    void exceptionThrowWhenStubbing() {
        // given

        // when

        // then
        Assertions.assertThrows(Exception.class, () -> {
            Mockito.when(wrappingTestService.getWrappingDes()).thenReturn("stubbing des");
        });

    }
}
