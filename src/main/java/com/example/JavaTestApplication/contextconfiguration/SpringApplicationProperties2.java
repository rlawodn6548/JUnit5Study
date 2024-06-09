package com.example.JavaTestApplication.contextconfiguration;

import com.example.JavaTestApplication.object.TestObject2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationProperties2 {
    @Bean
    TestObject2 testObject2() {
        return new TestObject2();
    }
}
