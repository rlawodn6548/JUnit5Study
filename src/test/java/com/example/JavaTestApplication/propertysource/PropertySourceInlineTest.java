package com.example.JavaTestApplication.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties={"test.value=application_test file value"})
public class PropertySourceInlineTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void PropertySourceTest() {
        // given
        Environment environment = applicationContext.getEnvironment();
        // when

        // then
        Assertions.assertEquals("application_test file value", environment.getProperty("test.value"));
    }
}
