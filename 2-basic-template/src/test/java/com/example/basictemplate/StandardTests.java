package com.example.basictemplate;

import ch.qos.logback.classic.spi.PackagingDataCalculator;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Fail.fail;

/**
 * @author manhdt14
 * created in 10/13/2023 10:42 AM
 */
public class StandardTests {
    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll executed");
    }

    @Tag("DEV")
    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
    }

    @Test
    void succeedingTest() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4, 2 + 2);
    }

    @Tag("PROD")
    @Test
    @Disabled
    void failingTest() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(6,  2 + 4);
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll executed");
    }

}
