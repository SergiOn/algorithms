package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RunningSumOf1dArrayTest {

    private RunningSumOf1dArray sut;

    @BeforeEach
    void setUp() {
        sut = new RunningSumOf1dArray();
    }

    @Test
    void test1() {
        final int[] nums = new int[]{1, 2, 3, 4};
        final int[] expected = new int[]{1, 3, 6, 10};

        assertThat(sut.runningSum(nums), equalTo(expected));
    }

}