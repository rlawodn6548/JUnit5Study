package com.example.JavaTestApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CaculatorGivenWhenThenTest {

    @Test
    @DisplayName("Integer 두 개가 주어질 경우, Calculator.plus() 메소드 테스트")
    void calculatorPlusTwoInteger() {
        // given
        Integer a = 1;
        Integer b = 2;

        // when
        Integer result = Calculator.plus(a, b);

        // then
        Assertions.assertEquals(3, result, "1 더하기 2는 3이다.");
    }
}
