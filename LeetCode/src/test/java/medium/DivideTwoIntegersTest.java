package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DivideTwoIntegersTest {

    private DivideTwoIntegers sut;

    @BeforeEach
    void setUp() {
        sut = new DivideTwoIntegers();
    }

    @Test
    void test1() {
        int actual = sut.divide(10, 3);
        assertThat(actual, is(3));
    }

    @Test
    void test2() {
        int actual = sut.divide(7, -3);
        assertThat(actual, is(-2));
    }

    @Test
    void test3() {
        int actual = sut.divide(-2147483648, -1);
        assertThat(actual, is(2147483647));
    }

    @Test
    void test4() {
        int actual = sut.divide(-2147483648, 1);
        assertThat(actual, is(-2147483648));
    }

    @Test
    void test5() {
        int actual = sut.divide(-1, 1);
        assertThat(actual, is(-1));
    }

    @Test
    void test6() {
        int actual = sut.divide(2147483647, 2);
        assertThat(actual, is(1073741823));
    }

    @Test
    void test7() {
        int actual = sut.divide(10, 2);
        assertThat(actual, is(5));
    }

    @Test
    void test8() {
        int actual = sut.divide(10, -2);
        assertThat(actual, is(-5));
    }

    @Test
    void test9() {
        int actual = sut.divide(-10, 2);
        assertThat(actual, is(-5));
    }

    @Test
    void test10() {
        int actual = sut.divide(-10, -2);
        assertThat(actual, is(5));
    }

}