package easy;

import java.util.Set;

/**
 * 1704. Determine if String Halves Are Alike
 *
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * You are given a string s of even length.
 * Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 * Constraints:
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 *
 * Example 1:
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 *
 * Example 2:
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 */

public class DetermineIfStringHalvesAreAlike {
    private static final Set<Character> vowels = Set.of(
            'a',
            'e',
            'i',
            'o',
            'u',
            'A',
            'E',
            'I',
            'O',
            'U'
    );

    public boolean halvesAreAlike(String s) {
        final int length = s.length();
        final int halfLength = length / 2;
        final String a = s.substring(0, halfLength);
        final String b = s.substring(halfLength, length);

        final long aCount = a.chars()
                .filter(c -> vowels.contains((char) c))
                .count();
        final long bCount = b.chars()
                .filter(c -> vowels.contains((char) c))
                .count();

        return aCount == bCount;
    }
}
