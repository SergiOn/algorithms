package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class SelfDividingNumbersTest {

    private SelfDividingNumbers sut;

    @BeforeEach
    void setUp() {
        sut = new SelfDividingNumbers();
    }

    @Test
    void test1() {
        assertThat(sut.selfDividingNumbers(1, 22), contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22));
    }

}
