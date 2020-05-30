package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private TwoSum sut;

    @BeforeEach
    void setUp() {
        sut = new TwoSum();
    }

    @Test
    void test1() {
        final int[] actual = new int[] { 2, 7, 11, 15 };
        final int target = 9;
        final int[] expected = new int[] { 0, 1 };
        assertArrayEquals(expected, sut.twoSum(actual, target));
    }

}