package medium.InsertDeleteGetRandomO1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedSet2Test {

    private RandomizedSet2 sut;

    @BeforeEach
    void beforeEach() {
        sut = new RandomizedSet2();
    }

    @Test
    void insert() {
        assertTrue(sut.insert(0));
        assertFalse(sut.insert(0));
        assertTrue(sut.insert(1));
        assertFalse(sut.insert(1));
    }

    @Test
    void remove() {
        assertFalse(sut.remove(0));
        assertFalse(sut.remove(1));
        sut.insert(0);
        assertTrue(sut.remove(0));
        assertFalse(sut.remove(1));
    }

    @Test
    void getRandom() {
        sut.getRandom();
        sut.insert(0);
        assertThat(sut.getRandom(), is(0));
        sut.insert(1);
        assertThat(sut.getRandom(), anyOf(is(0), is(1)));
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        assertThat(sut.getRandom(), anyOf(
                is(0),
                is(1),
                is(2),
                is(3),
                is(4),
                is(5)
        ));
        sut.remove(4);
        sut.remove(5);
        assertThat(sut.getRandom(), anyOf(
                is(0),
                is(1),
                is(2),
                is(3)
        ));
    }
}