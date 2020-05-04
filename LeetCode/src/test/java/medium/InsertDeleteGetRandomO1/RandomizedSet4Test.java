package medium.InsertDeleteGetRandomO1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedSet4Test {

    private RandomizedSet4 sut;

    @BeforeEach
    void beforeEach() {
        sut = new RandomizedSet4();
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

    @Test
    void flow1() {
        assertThat(sut.insert(1), is(true)); // [1]
        assertThat(sut.remove(2), is(false)); // [1]
        assertThat(sut.insert(2), is(true)); // [1,2]
        assertThat(sut.getRandom(), anyOf(is(1), is(2)));
        assertThat(sut.remove(1), is(true)); // [2]
        assertThat(sut.insert(2), is(false)); // [2]
        assertThat(sut.getRandom(), is(2));
    }

    @Test
    void flow2() {
        assertThat(sut.remove(0), is(false)); // []
        assertThat(sut.remove(0), is(false)); // []
        assertThat(sut.insert(0), is(true)); // [0]
        assertThat(sut.getRandom(), is(0));
        assertThat(sut.remove(0), is(true)); // []
        assertThat(sut.insert(0), is(true)); // [0]
    }
}