package com.example.JavaTestApplication.mockito.mock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TestService {
    private String name;
    private int number;

    public String getNameTimes() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < number; i++) {
            builder.append(name).append(" ");
        }
        return builder.substring(0, builder.length()-1);
    }
}
