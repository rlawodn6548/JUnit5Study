package com.example.JavaTestApplication.mockito.injectmocks;

import com.example.JavaTestApplication.mockito.mock.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class WrappingTestService {
    private TestService testService;
    private String wrappingDes;
}
