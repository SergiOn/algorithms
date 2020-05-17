package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NonDecreasingArrayTest {

    private NonDecreasingArray sut;

    @BeforeEach
    void setUp() {
        sut = new NonDecreasingArray();
    }

    @Test
    void test1() {
        boolean result = sut.checkPossibility(new int[] {4, 2, 3});
        assertTrue(result);
    }

    void test1a() {
        boolean result = sut.checkPossibility(new int[] {4, 2, 8});
        assertTrue(result);
    }

    @Test
    void test2() {
        boolean result = sut.checkPossibility(new int[] {4, 2, 1});
        assertFalse(result);
    }

    @Test
    void test3() {
        boolean result = sut.checkPossibility(new int[] {1, 2, 4});
        assertTrue(result);
    }

    @Test
    void test4() {
        boolean result = sut.checkPossibility(new int[] {3, 4, 2, 3});
        assertFalse(result);
    }

    @Test
    void test4a() {
        boolean result = sut.checkPossibility(new int[] {3, 4, 2, 8});
        assertTrue(result);
    }

    @Test
    void test4b() {
        boolean result = sut.checkPossibility(new int[] {1, 4, 2, 8});
        assertTrue(result);
    }

    @Test
    void test4c() {
        boolean result = sut.checkPossibility(new int[] {1, 4, 2, 2});
        assertTrue(result);
    }

    @Test
    void test4d() {
        boolean result = sut.checkPossibility(new int[] {1, 4, 2, 4});
        assertTrue(result);
    }

    @Test
    void test5() {
        boolean result = sut.checkPossibility(new int[] {1, 5, 4, 6, 7, 10, 8, 9});
        assertFalse(result);
    }

    @Test
    void test6() {
        boolean result = sut.checkPossibility(new int[] {2, 3, 3, 2, 4});
        assertTrue(result);
    }

    @Test
    void test7() {
        boolean result = sut.checkPossibility(new int[] {3, 3, 2, 2});
        assertFalse(result);
    }

    @Test
    void test8() {
        boolean result = sut.checkPossibility(new int[] {-1, 4, 2, 3});
        assertTrue(result);
    }

    @Test
    void test9() {
        boolean result = sut.checkPossibility(new int[] {1, 2, 5, 3, 3});
        assertTrue(result);
    }

    @Test
    void test10() {
        boolean result = sut.checkPossibility(new int[] {3, 1});
        assertTrue(result);
    }

    @Test
    void test11() {
        boolean result = sut.checkPossibility(new int[] {1, 2, 4, 5, 3});
        assertTrue(result);
    }

}
