package hard;

/**
 * 420. Strong Password Checker
 *
 * https://leetcode.com/problems/strong-password-checker
 *
 * A password is considered strong if below conditions are all met:
 *
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong,
 * assuming other conditions are met).
 *
 * Write a function strongPasswordChecker(s),
 * that takes a string s as input, and return the MINIMUM change required to make s a strong password.
 * If s is already strong, return 0.
 *
 * Insertion, deletion or replace of any one character are all considered as one change.
 *
 */

public class StrongPasswordChecker {
    private final int MIN_SIZE = 6;
    private final int MAX_SIZE = 20;
    private final int MAX_REPEATING_CHARACTER = 3;

    public int strongPasswordChecker(String s) {
        final int size = s.length();
        int minChangeRequired = 0;
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        int digitCount = 0;

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount += 1;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount += 1;
            } else if (Character.isDigit(c)) {
                digitCount += 1;
            }
        }


        if (size < MIN_SIZE) {
            int i = MAX_REPEATING_CHARACTER - 1;
            int addedToSize = 0;

            while (i < size) {
                boolean isCorrectChar = Character.isLowerCase(chars[i]) || Character.isUpperCase(chars[i]) || Character.isDigit(chars[i]);
                boolean characterRepeated = chars[i] == chars[i - 1] && chars[i] == chars[i - 2];
                if (isCorrectChar && characterRepeated) {
                    if (lowerCaseCount == 0) {
                        lowerCaseCount += 1;
                    } else if (upperCaseCount == 0) {
                        upperCaseCount += 1;
                    } else if (digitCount == 0) {
                        digitCount += 1;
                    }
                    minChangeRequired += 1;
                    i += MAX_REPEATING_CHARACTER;
                } else {
                    i += 1;
                }
            }
            while (lowerCaseCount == 0 || upperCaseCount == 0 || digitCount == 0) {
                if (lowerCaseCount == 0) {
                    lowerCaseCount += 1;
                } else if (upperCaseCount == 0) {
                    upperCaseCount += 1;
                } else {
                    digitCount += 1;
                }
                addedToSize += 1;
                minChangeRequired += 1;
            }

            minChangeRequired += (MIN_SIZE - size - addedToSize);
        }


        if (size > MAX_SIZE) {
            int i = MAX_REPEATING_CHARACTER - 1;
            int tookFromSize = 0;

            while (i < size) {
                boolean isCorrectChar = Character.isLowerCase(chars[i]) || Character.isUpperCase(chars[i]) || Character.isDigit(chars[i]);
                boolean characterRepeated = chars[i] == chars[i - 1] && chars[i] == chars[i - 2];
                if (isCorrectChar && characterRepeated) {
                    if ((i + 1) < size && chars[i] == chars[i + 1]) {
                        if (lowerCaseCount == 0) {
                            lowerCaseCount += 1;
                        } else if (upperCaseCount == 0) {
                            upperCaseCount += 1;
                        } else if (digitCount == 0) {
                            digitCount += 1;
                        }
                        i += MAX_REPEATING_CHARACTER;
                        minChangeRequired += 1;
                    } else if ((size - tookFromSize) > MAX_SIZE) {
                        tookFromSize += 1;
                        minChangeRequired += 1;
                        i += 1;
                    } else {
                        if (lowerCaseCount == 0) {
                            lowerCaseCount += 1;
                        } else if (upperCaseCount == 0) {
                            upperCaseCount += 1;
                        } else if (digitCount == 0) {
                            digitCount += 1;
                        }
                        i += MAX_REPEATING_CHARACTER;
                        minChangeRequired += 1;
                    }
                } else {
                    i += 1;
                }
            }

            int newSize = size;
            while (lowerCaseCount == 0 || upperCaseCount == 0 || digitCount == 0) {
                if (lowerCaseCount == 0) {
                    lowerCaseCount += 1;

                    if (upperCaseCount > 1) {
                        upperCaseCount -= 1;
                    } else if (digitCount > 1) {
                        digitCount -= 1;
                    } else {
                        newSize += 1;
                    }
                } else if (upperCaseCount == 0) {
                    upperCaseCount += 1;

                    if (lowerCaseCount > 1) {
                        lowerCaseCount -= 1;
                    } else if (digitCount > 1) {
                        digitCount -= 1;
                    } else {
                        newSize += 1;
                    }
                } else {
                    digitCount += 1;

                    if (lowerCaseCount > 1) {
                        lowerCaseCount -= 1;
                    } else if (upperCaseCount > 1) {
                        upperCaseCount -= 1;
                    } else {
                        newSize += 1;
                    }
                }
                minChangeRequired += 1;
            }
            minChangeRequired += (newSize - tookFromSize - MAX_SIZE);
        }


        if (size >= MIN_SIZE && size <= MAX_SIZE) {
            int i = MAX_REPEATING_CHARACTER - 1;

            while (i < size) {
                boolean isCorrectChar = Character.isLowerCase(chars[i]) || Character.isUpperCase(chars[i]) || Character.isDigit(chars[i]);
                boolean characterRepeated = chars[i] == chars[i - 1] && chars[i] == chars[i - 2];
                if (isCorrectChar && characterRepeated) {
                    if (lowerCaseCount == 0) {
                        lowerCaseCount += 1;
                    } else if (upperCaseCount == 0) {
                        upperCaseCount += 1;
                    } else if (digitCount == 0) {
                        digitCount  += 1;
                    }
                    i += MAX_REPEATING_CHARACTER;
                    minChangeRequired += 1;
                } else {
                    i += 1;
                }
            }

            int newSize = size;
            while (lowerCaseCount == 0 || upperCaseCount == 0 || digitCount == 0) {
                if (lowerCaseCount == 0) {
                    lowerCaseCount += 1;

                    if (upperCaseCount > 1) {
                        upperCaseCount -= 1;
                    } else if (digitCount > 1) {
                        digitCount -= 1;
                    } else {
                        newSize += 1;
                    }
                } else if (upperCaseCount == 0) {
                    upperCaseCount += 1;

                    if (lowerCaseCount > 1) {
                        lowerCaseCount -= 1;
                    } else if (digitCount > 1) {
                        digitCount -= 1;
                    } else {
                        newSize += 1;
                    }
                } else {
                    digitCount += 1;

                    if (lowerCaseCount > 1) {
                        lowerCaseCount -= 1;
                    } else if (upperCaseCount > 1) {
                        upperCaseCount -= 1;
                    } else {
                        newSize += 1;
                    }
                }
                minChangeRequired += 1;
            }
            minChangeRequired += (newSize - size);
        }

        return minChangeRequired;
    }
}
