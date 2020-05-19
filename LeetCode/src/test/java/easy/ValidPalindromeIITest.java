package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeIITest {

    private ValidPalindromeII sut;

    @BeforeEach
    void setUp() {
        sut = new ValidPalindromeII();
    }

    @Test
    void test1() {
        assertTrue(sut.validPalindrome("aba"));
    }

    @Test
    void test2() {
        assertTrue(sut.validPalindrome("abca"));
    }

    @Test
    void test3() {
        assertTrue(sut.validPalindrome("abcca"));
    }

    @Test
    void test4() {
        assertTrue(sut.validPalindrome("deeee"));
    }

    @Test
    void test5() {
        assertFalse(sut.validPalindrome("abc"));
    }

    @Test
    void test6() {
        assertTrue(sut.validPalindrome("cbbcc"));
    }

    @Test
    void test7() {
        assertTrue(sut.validPalindrome("ebcbbececabbacecbbcbe"));
    }

}