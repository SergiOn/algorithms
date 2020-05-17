package easy;

/**
 * 665. Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array
 *
 * Given an array nums with n integers,
 * your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing
 * if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 * Example 1:
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 * Example 2:
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 * Constraints:
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        final int length = nums.length;
        int errorCount = 0;

        if (length <= 2) {
            return true;
        }

        final int[] newNums = new int[length];
        System.arraycopy(nums, 0, newNums, 0, length);

        for (int i = 0; i < length - 1; i++) {
            if (newNums[i] > newNums[i + 1]) {
                errorCount += 1;

                if (i - 1 >= 0 && newNums[i - 1] <= newNums[i + 1]) {
                    newNums[i] = newNums[i - 1];
                } else if (i + 2 < length && newNums[i] <= newNums[i + 2]) {
                    newNums[i + 1] = newNums[i + 2];
                } else if (i - 1 >= 0 && i + 2 < length
                        && newNums[i + 1] <= newNums[i + 2]
                        && newNums[i - 1] <= newNums[i + 1]) {
                    newNums[i] = newNums[i + 1];
                } else if (i - 1 < 0 && newNums[i + 1] <= newNums[i + 2]) {
                    newNums[i] = newNums[i + 1];
                } else if (i + 2 == length) {
                    newNums[i + 1] = newNums[i];
                } else {
                    return false;
                }
            }
        }

        return errorCount < 2;
    }

}
