package medium;

/**
 * 238. Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        final int size = nums.length;
        final int[] output = new int[size];
        output[size - 1] = 1;

        for (int i = size - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }

        int temp = 1;
        for (int i = 0; i < size; i++) {
            output[i] = output[i] * temp;
            temp *= nums[i];
        }

        return output;
    }

    public int[] productExceptSelf3(int[] nums) {
        final int size = nums.length;
        final int[] output = new int[size];
        output[0] = 1;

        for (int i = 1; i < size; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = size - 1; i >= 0; i--) {
            output[i] = output[i] * temp;
            temp *= nums[i];
        }

        return output;
    }

    public int[] productExceptSelf2(int[] nums) {
        final int size = nums.length;
        final int[] fromLeftToRight = new int[size];
        fromLeftToRight[0] = 1;
        final int[] fromRightToLeft = new int[size];
        fromRightToLeft[size - 1] = 1;
        final int[] output = new int[size];

        for (int i = 1; i < size; i++) {
            int j = size - 1 - i;
            fromLeftToRight[i] = fromLeftToRight[i - 1] * nums[i - 1];
            fromRightToLeft[j] = fromRightToLeft[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < size; i++) {
            output[i] = fromLeftToRight[i] * fromRightToLeft[i];
        }

        return output;
    }

}
