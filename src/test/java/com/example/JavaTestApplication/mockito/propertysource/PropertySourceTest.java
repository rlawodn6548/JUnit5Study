package com.example.JavaTestApplication.mockito.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource("/applicationConfig.properties")
public class PropertySourceTest {
    // TestPropertySource는 yml 파일을 인식하지 못한다.
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
