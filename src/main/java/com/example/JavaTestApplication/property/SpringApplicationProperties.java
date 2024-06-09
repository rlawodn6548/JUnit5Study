package com.example.JavaTestApplication.property;

import com.example.JavaTestApplication.object.TestObject1;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationProperties {
    @Bean
    TestObject1 testObject1() {
        return new TestObject1();
    }
}
