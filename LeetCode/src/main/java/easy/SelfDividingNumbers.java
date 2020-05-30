package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 *
 * https://leetcode.com/problems/self-dividing-numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound,
 * output a list of every possible self dividing number,
 * including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        final int capacity = (int) ((right - left) * 0.7);
        List<Integer> list = new ArrayList<>(capacity);

        for (int i = left; i <= right; i++) {
            if (i < 10) {
                list.add(i);
            } else if (divideByMyself(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean divideByMyself(final int number) {
        final int[] numbers = Integer.toString(number).chars().map(Character::getNumericValue).toArray();

        for (final int n : numbers) {
            if (n == 0 || number % n != 0) {
                return false;
            }
        }
        return true;
    }

}
