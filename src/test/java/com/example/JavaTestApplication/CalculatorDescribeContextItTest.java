package com.example.JavaTestApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator 클래스의")
class CalculatorDescribeContextItTest {

    @Nested
    @DisplayName("Discribe : plus 메소드는")
    class Describe_plus {

        @Nested
        @DisplayName("Context : Integer인 두 값이 주어진다면")
        class Context_two_integer {

            private final Integer a = 1;
            private final Integer b = 2;
            @Test
            @DisplayName("It : 두 값의 합을 Integer로 반환한다.")
            void it_return_integer() {
                final Integer result = Calculator.plus(a, b);

                Assertions.assertEquals(3, result, "1 더하기 2는 3이다.");
            }
        }
    }

    @Nested
    @DisplayName("Discribe : minus 메소드는")
    class Discribe_minus {

        @Nested
        @DisplayName("Context : Integer인 두 값이 주어진다면")
        class Context_two_integer {

            private final Integer a = 1;
            private final Integer b = 2;
            @Test
            @DisplayName("It : 두 값의 뺄셈을 Integer로 반환한다.")
            void it_return_integer() {
                final Integer result = Calculator.minus(a, b);

                Assertions.assertEquals(-1, result, "1 빼기 2는 -1이다.");
            }
        }
    }
}