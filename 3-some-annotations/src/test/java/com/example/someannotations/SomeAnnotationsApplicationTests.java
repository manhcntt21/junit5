package com.example.someannotations;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SomeAnnotationsApplicationTests {
    public boolean isPalindrome(String candidate) {
        String str = "";
        int length = candidate.length();
        for(int i = length - 1; i >= 0; i--) {
            str = str + candidate.charAt(i);
        }
        if(str.toLowerCase(Locale.ROOT).equals(candidate.toLowerCase(Locale.ROOT))) {
            return true;
        }
        return false;
    }
    @Test
    void contextLoads() {
    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba", "abc" })
    void palindromes(String candidate) {
        assertTrue(isPalindrome(candidate));
    }

    @RepeatedTest(10)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Executing repeated test #" + repetitionInfo.getCurrentRepetition());
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }
}
