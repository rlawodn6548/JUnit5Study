package com.example.JavaTestApplication.junit;

import com.example.JavaTestApplication.Study;
import com.example.JavaTestApplication.junit.FindSlowTestExtension;
import com.example.JavaTestApplication.junit.tag.FastTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
class StudyTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Test
    @DisplayName("Java 객체 생성 테스트")
    void create() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        log.info("create");
    }

    @Test
    void create2() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        log.info("create2");
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
        log.info("tagFirstTest");
    }

    @FastTag
    void fastTagTest() {
        log.info("Fast Tag Test");
    }

    @RepeatedTest(5)
    void repeatTest() {
        log.info("repeated Test");
    }

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest2(RepetitionInfo repetitionInfo) {
        log.info("repeated Test {}/{}", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있어요"})
    void parameterizedTest(String message) {
        log.info(message);
    }

    @BeforeAll
    static void beforeAll() {
        log.info("before All");
    }

    @AfterAll
    static void afterAll() {
        log.info("after All");
    }

    @BeforeEach
    void beforeEach() {
        log.info("before each");
    }

    @AfterEach
    void afterEach() {
        log.info("after each");
    }
}