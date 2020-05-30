package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParityTest {

    private SortArrayByParity sut;

    @BeforeEach
    void setUp() {
        sut = new SortArrayByParity();
    }

    @Test
    void test1() {
        final int[] actual = new int[] { 3, 1, 2, 4 };
        final int[] expected = new int[] { 2, 4, 3, 1 };
        assertArrayEquals(expected, sut.sortArrayByParity(actual));
    }

}