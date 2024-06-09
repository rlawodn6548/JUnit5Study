package com.example.JavaTestApplication.propertysource;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class TestService {
    private String property;
    public TestService(String property) {
        this.property = property;
    }
}
