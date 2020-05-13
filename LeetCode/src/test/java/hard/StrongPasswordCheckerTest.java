package hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StrongPasswordCheckerTest {

    private StrongPasswordChecker sut;

    @BeforeEach
    void setUp() {
        sut = new StrongPasswordChecker();
    }

    @Test
    void test1() {
        int actual = sut.strongPasswordChecker("");
        assertThat(actual, is(6));
    }

    @Test
    void test2() {
        int actual = sut.strongPasswordChecker("aaa123");
        assertThat(actual, is(1));
    }

    @Test
    void test3() {
        int actual = sut.strongPasswordChecker("aaa111");
        assertThat(actual, is(2));
    }

    @Test
    void test4() {
        // 21
        int actual = sut.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa");
        assertThat(actual, is(7));
    }

    @Test
    void test5() {
        // 21
        int actual = sut.strongPasswordChecker("ABABABABABABABABABAB1");
        assertThat(actual, is(2));
    }

    @Test
    void test6() {
        int actual = sut.strongPasswordChecker("...");
        assertThat(actual, is(3));
    }

    @Test
    void test7() {
        // 21
        int actual = sut.strongPasswordChecker("aaaabbaaabbaaa123456A");
        assertThat(actual, is(3));
    }

    @Test
    void test8() {
        // 22
        int actual = sut.strongPasswordChecker("1234567890123456Baaaaa");
        assertThat(actual, is(3));
    }

    @Test
    void test9() {
        // 21
        int actual = sut.strongPasswordChecker("..................!!!");
        assertThat(actual, is(7));
    }

    @Test
    void test10() {
        // 22
        int actual = sut.strongPasswordChecker("1Abababcaaaabababababa");
        assertThat(actual, is(2));
    }

}