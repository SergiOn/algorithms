package hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MinimumDistanceToTypeWordUsingTwoFingersTest {

    private MinimumDistanceToTypeWordUsingTwoFingers sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumDistanceToTypeWordUsingTwoFingers();
    }

    @Test
    void test1() {
        int actual = sut.minimumDistance("CAKE");
        assertThat(actual, is(3));
    }

    @Test
    void test2() {
        int actual = sut.minimumDistance("HAPPY");
        assertThat(actual, is(6));
    }

    @Test
    void test3() {
        int actual = sut.minimumDistance("NEW");
        assertThat(actual, is(3));
    }

    @Test
    void test4() {
        int actual = sut.minimumDistance("YEAR");
        assertThat(actual, is(7));
    }

    @Test
    void test5() {
        int actual = sut.minimumDistance("JDX");
        assertThat(actual, is(1));
    }

    @Test
    void test6() {
        int actual = sut.minimumDistance("QIBZR");
        assertThat(actual, is(7));
    }

    @Test
    void test7() {
        int actual = sut.minimumDistance("XM");
        assertThat(actual, is(0));
    }

    @Test
    @Disabled
    void test8() {
        int actual = sut.minimumDistance("OPVUWZLCKTDPSUKGHAXIDWHLZFKNBDZEWHBSURTVCADUGTSDMCLDBTAGFWDPGXZBVARNTDICHCUJLNFBQOBTDWMGILXPSFWVGYBZVFFKQIDTOVFAPVNSQJULMVIERWAOXCKXBRI");
        assertThat(actual, is(0));
    }

}
