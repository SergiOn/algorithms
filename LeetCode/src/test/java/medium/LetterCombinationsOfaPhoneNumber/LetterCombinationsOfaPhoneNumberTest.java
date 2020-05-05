package medium.LetterCombinationsOfaPhoneNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

class LetterCombinationsOfaPhoneNumberTest {

    private LetterCombinationsOfaPhoneNumber sut;

    @BeforeEach
    void setUp() {
        sut = new LetterCombinationsOfaPhoneNumber();
    }

    @Test
    void letterCombinations1() {
        var expected = containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertThat(sut.letterCombinations("23"), expected);
    }

    @Test
    void letterCombinations2() {
        var expected = containsInAnyOrder("dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi");
        assertThat(sut.letterCombinations("34"), expected);
    }

    @Test
    void letterCombinations3() {
        var expected = containsInAnyOrder("gj", "gk", "gl", "hj", "hk", "hl", "ij", "ik", "il");
        assertThat(sut.letterCombinations("45"), expected);
    }

    @Test
    void letterCombinations4() {
        assertThat(sut.letterCombinations(""), empty());
    }

    @Test
    void letterCombinations5() {
        var expected = containsInAnyOrder("a", "b", "c");
        assertThat(sut.letterCombinations("2"), expected);
    }

    @Test
    void letterCombinations6() {
        var expected = containsInAnyOrder("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh",
                "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi");
        assertThat(sut.letterCombinations("234"), expected);
    }

}
