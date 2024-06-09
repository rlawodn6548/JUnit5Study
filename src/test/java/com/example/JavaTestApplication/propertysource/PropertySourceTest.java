package com.example.JavaTestApplication.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=AppConfig.class)
@TestPropertySource("/applicationConfig.properties")
public class PropertySourceTest {
    // TestPropertySource는 yml 파일을 인식하지 못한다.
    @Autowired
    private TestService testService;

    @Test
    void PropertySourceTest() {
        // given

        // when

        // then
        Assertions.assertEquals("application_test file value", testService.getProperty());
    }
}
