package easy;

/**
 * 7. Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment
 * which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int integer = sign * x;
        int reversed = 0;

        while (integer != 0) {
            if (reversed * 10 / 10 != reversed) {
                return 0;
            }

            int number = integer % 10;
            reversed = reversed * 10 + number;
            integer /= 10;
        }

        return sign * reversed;
    }

}
