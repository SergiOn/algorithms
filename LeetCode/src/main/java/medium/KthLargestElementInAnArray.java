package medium;

/**
 * 215. Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        final int[] numsSorted = sort(nums);
        return numsSorted[k - 1];
    }

    private int[] sort(final int[] arr) {
        final int length = arr.length;
        final int[] array = new int[length];
        System.arraycopy(arr, 0, array, 0, length);

        int index = 0;
        int indexBeforeSwapped = 0;

        while (index < length - 1) {
            if (array[index] < array[index + 1]) {
                final int temp = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temp;

                if (index - 1 >= 0) {
                    index -= 1;
                }
            } else if (index < indexBeforeSwapped) {
                index = indexBeforeSwapped;
            } else {
                index += 1;
                indexBeforeSwapped = index;
            }
        }
        return array;
    }

}
