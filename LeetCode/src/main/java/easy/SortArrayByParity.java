package easy;

/**
 * 905. Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity
 *
 * Given an array A of non-negative integers,
 * return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        final int length = A.length;
        final int[] correct = new int[length];
        final int[] odd = new int[length];

        int correctIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < length; i++) {
            final int number = A[i];

            if (number % 2 == 0) {
                correct[correctIndex] = number;
                correctIndex += 1;
            } else {
                odd[oddIndex] = number;
                oddIndex += 1;
            }
        }

        for (int i = 0; i < oddIndex; i++) {
            correct[correctIndex + i] = odd[i];
        }

        return correct;
    }

}
