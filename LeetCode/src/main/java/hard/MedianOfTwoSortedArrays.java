package hard;

/**
 * #4
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int size1 = nums1.length;
        final int size2 = nums2.length;
        final int size = size1 + size2;
        final int[] nums;

        if (size1 == 0 || size2 == 0) {
            if (size1 == 0) {
                nums = nums2;
            } else {
                nums = nums1;
            }
        } else if (nums1[size1 - 1] < nums2[0] || nums2[size2 - 1] < nums1[0]) {
            nums = new int[size];

            if (nums1[size1 - 1] < nums2[0]) {
                for (int i = 0; i < size1; i++) {
                    nums[i] = nums1[i];
                }
                for (int i = 0; i < size2; i++) {
                    nums[i + size1] = nums2[i];
                }
            } else {
                for (int i = 0; i < size2; i++) {
                    nums[i] = nums2[i];
                }
                for (int i = 0; i < size1; i++) {
                    nums[i + size2] = nums1[i];
                }
            }
        } else {
            nums = new int[size];

            for (int i = 0, i1 = 0, i2 = 0; i < size; i++) {
                if (i1 == size1) {
                    nums[i] = nums2[i2];
                    i2++;
                } else if (i2 == size2) {
                    nums[i] = nums1[i1];
                    i1++;
                } else if (nums1[i1] < nums2[i2]) {
                    nums[i] = nums1[i1];
                    i1++;
                } else {
                    nums[i] = nums2[i2];
                    i2++;
                }
            }
        }

        if (size % 2 == 0) {
            int middleR = size / 2;
            int middleL = middleR - 1;
            double sum = nums[middleL] + nums[middleR];
            return sum / 2;
        } else {
            int middle = (size / 2);
            return (double) nums[middle];
        }
    }

}
