package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetermineIfStringHalvesAreAlikeTest {

    private DetermineIfStringHalvesAreAlike sut;

    @BeforeEach
    void beforeEach() {
        sut = new DetermineIfStringHalvesAreAlike();
    }

    @Test
    @DisplayName("book")
    void test1() {
        boolean result = sut.halvesAreAlike("book");
        assertTrue(result);
    }

    @Test
    @DisplayName("textbook")
    void test2() {
        boolean result = sut.halvesAreAlike("textbook");
        assertFalse(result);
    }
}
