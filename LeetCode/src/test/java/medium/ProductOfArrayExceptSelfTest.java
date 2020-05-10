package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ProductOfArrayExceptSelfTest {

    private ProductOfArrayExceptSelf sut;

    @BeforeEach
    void setUp() {
        sut = new ProductOfArrayExceptSelf();
    }

    @Test
    void productExceptSelf() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, sut.productExceptSelf(array));
    }

}