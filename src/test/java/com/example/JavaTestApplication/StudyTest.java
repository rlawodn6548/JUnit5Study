package com.example.JavaTestApplication;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

class StudyTest {

    @Test
    @Tag("fast")
    @DisplayName("Java 객체 생성 테스트")
    void create() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        System.out.println("create");
    }

    @Test
    void create2() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        System.out.println("create2");
    }

//    @Test
//    void assertionsTest() {
//        Study study = new Study();
//        Assertions.assertNotNull(study);
//        Assertions.assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 생성하면 DRAFT 상태여야함.");
//    }
//
//    @Test
//    void assertAll() {
//        Study study = new Study();
//        Assertions.assertAll(
//                () -> Assertions.assertNotNull(study),
//                () -> Assertions.assertEquals(StudyStatus.ENDED, study.getStatus()),
//                () -> Assertions.assertTrue(study.getStatus() == StudyStatus.STARTED)
//        );
//    }

    @Test
    void assertThrow() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });
    }

//    @Test
//    void assertTimeout() {
//        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
//            Thread.sleep(300);
//        });
//    }
//
//    @Test
//    void assertTimeoutPreemTively() {
//        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            Thread.sleep(300);
//        });
//    }
//
//    @Test
//    void conditionalTestOld() {
//        String testEnv = System.getenv("TEST_ENV");
//        Assertions.assertTrue("LOCAL".equalsIgnoreCase(testEnv));
//
//        // add Test Logic
//    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void conditionalTestAnnotation() {
        // add Test Logic
    }

    @Test
    @DisabledOnOs({OS.MAC, OS.LINUX})
    @EnabledIfEnvironmentVariable(named="EnvVariableKey", matches="expectedEnvValue")
    @EnabledIfSystemProperty(named = "propertyKey", matches = "expectedPropertyValue")
    void conditionalTestAnnotation2() {
        // add test logic
    }

    @Test
    @Tag("First")
    void tagFirstTest() {
        Assertions.assertTrue(true);
        System.out.println("tagFirstTest");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}