package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class KthLargestElementInAnArrayTest {

    private KthLargestElementInAnArray sut;

    @BeforeEach
    void setUp() {
        sut = new KthLargestElementInAnArray();
    }

    @Test
    void test1() {
        int actual = sut.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2);
        assertThat(actual, is(5));
    }

    @Test
    void test2() {
        int actual = sut.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        assertThat(actual, is(4));
    }

}