package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StringToIntegerTest {

    private StringToInteger sut;

    @BeforeEach
    void beforeEach() {
        sut = new StringToInteger();
    }

    @Test
    @DisplayName("words and 987")
    void test1() {
        final int actual = sut.myAtoi("words and 987");
        assertThat(actual, is(0));
    }

    @Test
    @DisplayName("9223372036854775808")
    void test2() {
        final int actual = sut.myAtoi("9223372036854775808");
        assertThat(actual, is(2147483647));
    }
}