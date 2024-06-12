package com.example.JavaTestApplication.mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockTest {
    @Mock
    private TestService testService;
    
    @Test
    void mockTest() {
        // given
        
        // when 

        // then 
        Assertions.assertNull(testService.getName());
        Assertions.assertEquals(0, testService.getNumber());
        Assertions.assertNull(testService.getNameTimes());
    }

    @Test
    void stubbingMockTest() {
        // given
        Mockito.when(testService.getName()).thenReturn("MockName");
        Mockito.when(testService.getNumber()).thenReturn(10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<10; i++) {
            sb.append(testService.getName()).append(" ");
        }
        String nameTimes = sb.substring(0, sb.length()-1);
        Mockito.when(testService.getNameTimes()).thenReturn(nameTimes);

        // when

        // then
        Assertions.assertEquals("MockName", testService.getName());
        Assertions.assertEquals(10, testService.getNumber());
        Assertions.assertEquals(nameTimes, testService.getNameTimes());
    }
}
