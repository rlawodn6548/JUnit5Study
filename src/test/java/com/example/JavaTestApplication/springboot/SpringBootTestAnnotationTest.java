package com.example.JavaTestApplication.springboot;

import com.example.JavaTestApplication.object.TestObject1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@SpringBootTest
@TestPropertySource("/applicationConfig.properties")
public class SpringBootTestAnnotationTest {
    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    void test1() {
        // given
        TestObject1 testObject1 = (TestObject1) applicationContext.getBean("testObject1");
        // when
        testObject1.setName("test1");
        // then

    }

    @Test
    void test2() {
        // given
        TestObject1 testObject1 = (TestObject1) applicationContext.getBean("testObject1");
        // when

        // then
        Assertions.assertEquals("test1", testObject1.getName());
    }
}
