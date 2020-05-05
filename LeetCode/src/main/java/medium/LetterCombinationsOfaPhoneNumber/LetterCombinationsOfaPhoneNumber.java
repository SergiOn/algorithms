package medium.LetterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

public class LetterCombinationsOfaPhoneNumber {
    private final String[][] phoneNumbers = {
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return List.of();
        }

        int size = 1;
        final String[][] numbers = new String[length][];
        for (int i = 0; i < length; i++) {
            numbers[i] = phoneNumbers[Character.getNumericValue(digits.charAt(i))];
            size *= numbers[i].length;
        }

        final List<String> strings = new ArrayList<>(size);
        /**
         * stringProcess method mutate the List<String> strings
         * mutation in performance reason
         */
        stringProcess(strings, numbers, 0, numbers.length - 1, "");
        return strings;
    }

    private void stringProcess(List<String> strings, String[][] numbers, int index, int lastIndex, String string) {
        if (index != lastIndex) {
            for (String s : numbers[index]) {
                stringProcess(strings, numbers, index + 1, lastIndex, string + s);
            }
        } else {
            for (String s : numbers[index]) {
                strings.add(string + s);
            }
        }
    }



    public List<String> letterCombinations2(String digits) {
        int length = digits.length();
        if (length == 0) {
            return List.of();
        }

        if (digits.length() == 1) {
            int index = Character.getNumericValue(digits.charAt(0));
            return List.of(phoneNumbers[index]);
        }

        int left = Character.getNumericValue(digits.charAt(0));
        int right = Character.getNumericValue(digits.charAt(1));
        int leftSize = phoneNumbers[left].length;
        int rightSize = phoneNumbers[right].length;
        int size = leftSize * rightSize;
        List<String> strings = new ArrayList<>(size);

        for (int i = 0; i < leftSize; i++) {
            for (int j = 0; j < rightSize; j++) {
                strings.add(phoneNumbers[left][i] + phoneNumbers[right][j]);
            }
        }

        return strings;
    }
}
