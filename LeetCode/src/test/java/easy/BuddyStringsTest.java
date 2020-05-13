package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BuddyStringsTest {

    private BuddyStrings sut;

    @BeforeEach
    void setUp() {
        sut = new BuddyStrings();
    }

    @Test
    void test1() {
        boolean result = sut.buddyStrings("ab", "ba");
        assertTrue(result);
    }

    @Test
    void test2() {
        boolean result = sut.buddyStrings("ab", "ab");
        assertFalse(result);
    }

    @Test
    void test3() {
        boolean result = sut.buddyStrings("aa", "aa");
        assertTrue(result);
    }

    @Test
    void test4() {
        boolean result = sut.buddyStrings("aaaaaaabc", "aaaaaaacb");
        assertTrue(result);
    }

    @Test
    void test5() {
        boolean result = sut.buddyStrings("", "aa");
        assertFalse(result);
    }

    @Test
    void test6() {
        boolean result = sut.buddyStrings("abcd", "badc");
        assertFalse(result);
    }

    @Test
    void test7() {
        boolean result = sut.buddyStrings("abab", "abab");
        assertTrue(result);
    }

    @Test
    void test8() {
        boolean result = sut.buddyStrings("abcaa", "abcbb");
        assertFalse(result);
    }

}
