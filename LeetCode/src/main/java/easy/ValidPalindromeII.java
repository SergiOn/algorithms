package easy;

/**
 * 680. Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii
 *
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 *
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        int deletedChars = 0;
        return validPalindromeFromIndex(s, leftIndex, rightIndex, deletedChars);
    }

    private boolean validPalindromeFromIndex(final String s, int leftIndex, int rightIndex, int deletedChars) {
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex += 1;
                rightIndex -= 1;
            } else if (deletedChars + 1 > 1) {
                return false;
            } else {
                return validPalindromeFromIndex(s, leftIndex + 1, rightIndex, deletedChars + 1)
                        || validPalindromeFromIndex(s, leftIndex, rightIndex - 1, deletedChars + 1);
            }
        }

        return true;
    }
}
