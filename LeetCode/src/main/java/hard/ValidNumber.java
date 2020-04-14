package hard;

/**
 * #65
 *
 * https://leetcode.com/problems/valid-number/
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * "e" => false
 * "3. " => true
 * ".1." => false
 * " .9" => true
 * " ." => false
 * "4e+" => false
 * "+.8" => true
 * " -." => false
 * "46.e3" => true
 * ".e1" => false
 *
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 */

public class ValidNumber {

    public boolean isNumber(String s) {
        final int size = s.length();
        boolean canBeSpaceAtStart = true;
        boolean canBeSign = true;
        boolean canBeE = true;
        boolean canBeDecimalPoint = true;
        boolean status = true;

        if (size == 1 && !checkNumber(s.charAt(0))) {
            return false;
        }

        for (int i = 1; i < size; i++) {
            if (!status) {
                break;
            }

            char previous = s.charAt(i - 1);
            char current = s.charAt(i);
            boolean lastIteration = i >= (size - 1);

            // space -> space
            if (checkSpace(previous) && checkSpace(current)) {
                continue;
            }
            // space -> sign
            if (checkSpace(previous) && checkSign(current) && canBeSign) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                continue;
            }
            // space -> decimalPoint
            if (checkSpace(previous) && checkDecimalPoint(current) && canBeDecimalPoint && !lastIteration) {
                canBeSpaceAtStart = false;
                canBeDecimalPoint = false;
                continue;
            }
            // space -> number
            if (checkSpace(previous) && checkNumber(current) && canBeSpaceAtStart) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                continue;
            }
            // sign -> number
            if (checkSign(previous) && checkNumber(current)) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                continue;
            }
            // sign -> decimalPoint
            if (checkSign(previous) && checkDecimalPoint(current) && canBeDecimalPoint && !lastIteration) {
                canBeSpaceAtStart = false;
                canBeDecimalPoint = false;
                continue;
            }
            // number -> number
            if (checkNumber(previous) && checkNumber(current)) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                continue;
            }
            // number -> e
            if (checkNumber(previous) && checkE(current) && canBeE && !lastIteration) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                canBeE = false;
                canBeDecimalPoint = false;
                continue;
            }
            // . -> e
            if (i > 1 && checkDecimalPoint(previous) && checkE(current) && canBeE && !lastIteration) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                canBeE = false;
                continue;
            }
            // e -> sign ( -> e -> sign)
            if (i > 1 && checkE(previous) && checkSign(current) && !lastIteration) {
                canBeDecimalPoint = false;
                continue;
            }
            // e -> number ( -> e -> number)
            if (i > 1 && checkE(previous) && checkNumber(current)) {
                canBeDecimalPoint = false;
                continue;
            }
            // number -> .
            if (checkNumber(previous) && checkDecimalPoint(current) && canBeDecimalPoint) {
                canBeSpaceAtStart = false;
                canBeDecimalPoint = false;
                continue;
            }
            // . -> number
            if (checkDecimalPoint(previous) && checkNumber(current)) {
                canBeDecimalPoint = false;
                continue;
            }
            // number -> space
            if (checkNumber(previous) && checkSpace(current)) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                canBeE = false;
                canBeDecimalPoint = false;
                continue;
            }
            // . -> space (number -> . -> space)
            if (i > 1 && checkNumber(s.charAt(i - 2)) && checkDecimalPoint(previous) && checkSpace(current)) {
                canBeSpaceAtStart = false;
                canBeSign = false;
                canBeE = false;
                canBeDecimalPoint = false;
                continue;
            }

            status = false;
        }

        return status;
    }

    private boolean checkSpace(char c) {
        return c == ' ';
    }

    private boolean checkNumber(char c) {
        char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        for (char number : numbers) {
            if (number == c) {
                return true;
            }
        }
        return false;
    }

    private boolean checkE(char c) {
        return c == 'e';
    }

    private boolean checkDecimalPoint(char c) {
        return c == '.';
    }

    private boolean checkSign(char c) {
        return c == '-' || c == '+';
    }

}
