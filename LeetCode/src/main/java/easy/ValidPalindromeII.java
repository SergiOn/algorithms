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
        int deletedLeftChars = 0;
        int deletedRightChars = 0;

        while (leftIndex < rightIndex) {
            final char leftChar = s.charAt(leftIndex);
            final char rightChar = s.charAt(rightIndex);

            if (leftChar == rightChar) {
                leftIndex += 1;
                rightIndex -= 1;
            } else if (leftIndex + 1 != rightIndex) {
                if (leftChar == s.charAt(rightIndex - 1)) {
                    deletedRightChars += 1;
                    rightIndex -= 1;
                } else if (s.charAt(leftIndex + 1) == rightChar) {
                    deletedLeftChars += 1;
                    leftIndex += 1;
                } else {
                    leftIndex += 1;
                    rightIndex -= 1;
                    deletedLeftChars += 1;
                    deletedRightChars += 1;
                }
            } else {
                leftIndex += 1;
            }
        }

        if ((deletedLeftChars + deletedRightChars) > 1) {
            return false;
        }

        return true;
    }
}

/*
* public boolean validPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        int deletedChars = 0;
        return validPalindromeFromIndex(s, leftIndex, rightIndex, deletedChars);
    }

    private boolean validPalindromeFromIndex(final String s, int leftIndex, int rightIndex, int deletedChars) {
        if (deletedChars > 1) {
            return false;
        }

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
*
* */