package hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    private MedianOfTwoSortedArrays sut;

    @BeforeEach
    void beforeEach() {
        sut = new MedianOfTwoSortedArrays();
    }

    @Test
    void findMedianSortedArraysEx1() {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        assertThat(sut.findMedianSortedArrays(nums1, nums2), is(2.0));
    }

    @Test
    void findMedianSortedArraysEx2() {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        assertThat(sut.findMedianSortedArrays(nums1, nums2), is(2.5));
    }

    @Test
    void findMedianSortedArraysEx3() {
        int[] nums1 = { };
        int[] nums2 = { 3, 4 };
        assertThat(sut.findMedianSortedArrays(nums1, nums2), is(3.5));
    }

    @Test
    void findMedianSortedArraysEx4() {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { };
        assertThat(sut.findMedianSortedArrays(nums1, nums2), is(1.5));
    }

}
