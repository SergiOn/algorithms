package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 859. Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings
 *
 * Given two strings A and B of lowercase letters,
 * return true if and only if we can swap two letters in A so that the result equals B.
 *
 * Example 1:
 * Input: A = "ab", B = "ba"
 * Output: true
 *
 * Example 2:
 * Input: A = "ab", B = "ab"
 * Output: false
 *
 * Example 3:
 * Input: A = "aa", B = "aa"
 * Output: true
 *
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 *
 * Example 5:
 * Input: A = "", B = "aa"
 * Output: false
 *
 * Note:
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        final int length = A.length();

        if (length != B.length()) {
            return false;
        }

        boolean letterSwapped = false;
        boolean letterSwappedCorrect = false;
        char swapLetterA = ' ';
        char swapLetterB = ' ';

        final Map<Character, Integer> countCharacters = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char charA = A.charAt(i);
            char charB = B.charAt(i);

            if (!letterSwapped && charA != charB) {
                swapLetterA = charA;
                swapLetterB = charB;
                letterSwapped = true;
            }

            if (letterSwapped && charA != charB) {
                letterSwappedCorrect = charA == swapLetterB && charB == swapLetterA;
            }

            Integer count = countCharacters.get(charA);
            count = count == null ? 1 : count + 1;
            countCharacters.put(charA, count);
        }

//        final boolean hasDuplicatesChar = A.chars()
//                .mapToObj(item -> (char) item)
//                .collect(Collectors.groupingBy(v -> v))
//                .entrySet()
//                .stream()
//                .anyMatch(es -> es.getValue().size() > 1);

        final boolean hasDuplicatesChar = countCharacters
                .entrySet()
                .stream()
                .anyMatch(es -> es.getValue() > 1);

        return letterSwapped ? letterSwappedCorrect : hasDuplicatesChar;
    }

}
