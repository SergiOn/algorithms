package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

    private MinimumNumberOfStepsToMakeTwoStringsAnagram sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumNumberOfStepsToMakeTwoStringsAnagram();
    }

    @Test
    void test1() {
        int actual = sut.minSteps("bab", "aba");
        assertThat(actual, is(1));
    }

    @Test
    void test2() {
        int actual = sut.minSteps("leetcode", "practice");
        assertThat(actual, is(5));
    }

    @Test
    void test3() {
        int actual = sut.minSteps("anagram", "mangaar");
        assertThat(actual, is(0));
    }

    @Test
    void test4() {
        int actual = sut.minSteps("xxyyzz", "xxyyzz");
        assertThat(actual, is(0));
    }

    @Test
    void test5() {
        int actual = sut.minSteps("friend", "family");
        assertThat(actual, is(4));
    }

}