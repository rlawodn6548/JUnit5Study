package com.example.JavaTestApplication.property;

import com.example.JavaTestApplication.object.TestObject1;
import com.example.JavaTestApplication.object.TestObject2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes=SpringApplicationProperties2.class)
@ExtendWith(SpringExtension.class)
class SpringApplicationProperties2Test {

    @Autowired(required = false)
    TestObject1 testObject1;

    @Autowired(required = false)
    TestObject2 testObject2;

    @Test
    @DisplayName("@ContextConfiguration 테스트")
    public void contextConfigurationTest() {
        // given

        // when

        // then
        Assertions.assertNull(testObject1);
        Assertions.assertNotNull(testObject2);
    }
}