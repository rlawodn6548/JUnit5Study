package com.example.JavaTestApplication.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    public TestService testService() {
        String property = env.getProperty("test.value");
        return new TestService(property);
    }
}
