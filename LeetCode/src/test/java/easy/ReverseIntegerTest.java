package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ReverseIntegerTest {

    private ReverseInteger sut;

    @BeforeEach
    void setUp() {
        sut = new ReverseInteger();
    }

    @Test
    void test1() {
        int actual = sut.reverse(123);
        assertThat(actual, is(321));
    }

    @Test
    void test2() {
        int actual = sut.reverse(-123);
        assertThat(actual, is(-321));
    }

    @Test
    void test3() {
        int actual = sut.reverse(120);
        assertThat(actual, is(21));
    }

    @Test
    void test4() {
        int actual = sut.reverse(1534236469);
        assertThat(actual, is(0));
    }
}