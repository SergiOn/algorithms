package hard;

/**
 * 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers
 *
 * A | B | C | D | E | F
 * ---------------------
 * G | H | I | J | K | L
 * ---------------------
 * M | N | O | P | Q | R
 * ---------------------
 * S | T | U | V | W | X
 * ---------------------
 * Y | Z
 *
 * You have a keyboard layout as shown above in the XY plane,
 * where each English uppercase letter is located at some coordinate,
 * for example, the letter A is located at coordinate (0,0),
 * the letter B is located at coordinate (0,1),
 * the letter P is located at coordinate (2,3)
 * and the letter Z is located at coordinate (4,1).
 *
 * Given the string word,
 * return the minimum total distance to type such string using only two fingers.
 * The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|.
 *
 * Note that the initial positions of your two fingers are considered free
 * so don't count towards your total distance,
 * also your two fingers do not have to start at the first letter or the first two letters.
 *
 * Example 1:
 * Input: word = "CAKE"
 * Output: 3
 * Explanation:
 * Using two fingers, one optimal way to type "CAKE" is:
 * Finger 1 on letter 'C' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
 * Finger 2 on letter 'K' -> cost = 0
 * Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
 * Total distance = 3
 *
 * Example 2:
 * Input: word = "HAPPY"
 * Output: 6
 * Explanation:
 * Using two fingers, one optimal way to type "HAPPY" is:
 * Finger 1 on letter 'H' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
 * Finger 2 on letter 'P' -> cost = 0
 * Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
 * Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
 * Total distance = 6
 */

public class MinimumDistanceToTypeWordUsingTwoFingers {

    public int minimumDistance(String word) {
        final char[] chars = word.toCharArray();
        final int length = chars.length;
        int distance = 0;

        for (int i = 1; i < length; i++) {
            int d = calculateMinimumDistance(chars, length, 0, i);

            if (distance == 0) {
                distance = d;
            } else if (d != 0 && d < distance) {
                distance = d;
            }
        }

        return distance;
    }

    private int calculateMinimumDistance(final char[] chars, final int length, final int firstFinger, final int secondFinger) {
        int nextFinger = Math.min(firstFinger, secondFinger) + 1;

        while (nextFinger == firstFinger || nextFinger == secondFinger) {
            nextFinger += 1;
        }

        if (nextFinger >= length) {
            return 0;
        }

        final int diff1 = calculateRecursionDistance(0, chars, length, firstFinger, secondFinger, nextFinger);
        final int diff2 = calculateRecursionDistance(0, chars, length, secondFinger, firstFinger, nextFinger);
        return Math.min(diff1, diff2);
    }

    private int calculateRecursionDistance(int distance, char[] chars, int length, int finger1, int finger2, int nextFinger1) {
        final int dist = distance + distanceBetweenChars(chars[finger1], chars[nextFinger1]);
        int newNextFinger = nextFinger1 + 1;

        while (newNextFinger == finger1 || newNextFinger == finger2) {
            newNextFinger += 1;
        }

        if (newNextFinger >= length) {
            return dist;
        }

        final int diff1 = calculateRecursionDistance(dist, chars, length, nextFinger1, finger2, newNextFinger);
        final int diff2 = calculateRecursionDistance(dist, chars, length, finger2, nextFinger1, newNextFinger);
        return Math.min(diff1, diff2);
    }

    private int distanceBetweenChars(char left, char right) {
        final int charANumber = 65;
        final int leftNumber = (int) left - charANumber;
        final int rightNumber = (int) right - charANumber;

        final int verticalLeft = leftNumber / 6;
        final int horizontalLeft = leftNumber - verticalLeft * 6;
        final int verticalRight = rightNumber / 6;
        final int horizontalRight = rightNumber - verticalRight * 6;

        return Math.abs(verticalLeft - verticalRight) + Math.abs(horizontalLeft - horizontalRight);
    }

    // CAKE

    // C | A
    // C -> K | A
    // K -> E | A
    // 3 + 1

    // C | A
    // C -> K | A
    // A -> E | K
    // 3 + 4

    // C | A
    // A -> K | C
    // K -> E | C
    // 5 + 1

    // C | A
    // A -> K | C
    // C -> E | K
    // 5 + 2

    public int minimumDistance2(String word) {
        final char[] chars = word.toCharArray();
        final int length = chars.length;

        int firstFingerIndex = 0;
        int secondFingerIndex = length - 2;
        int maxDiff = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            int diff = distanceBetweenChars(chars[i], chars[i + 1]);
            if (diff > maxDiff) {
                maxDiff = diff;
                secondFingerIndex = i + 1;
            }
        }

        int road = 0;

        for (int i = 0; i < length - 1; i++) {
            if (i < secondFingerIndex && i + 1 != secondFingerIndex) {
                road = road + distanceBetweenChars(chars[i], chars[i + 1]);
                firstFingerIndex = i + 1;

            } else if (i >= secondFingerIndex) {
                int diff1 = distanceBetweenChars(chars[firstFingerIndex], chars[i + 1]);
                int diff2 = distanceBetweenChars(chars[secondFingerIndex], chars[i + 1]);

                if (diff1 < diff2) {
                    firstFingerIndex = i + 1;
                    road = road + diff1;

                } else if (diff2 < diff1) {
                    secondFingerIndex = i + 1;
                    road = road + diff2;

                } else if (i + 2 < length) {
                    int diff11 = distanceBetweenChars(chars[firstFingerIndex], chars[i + 2]);
                    int diff22 = distanceBetweenChars(chars[secondFingerIndex], chars[i + 2]);

                    if (diff11 > diff22) {
                        firstFingerIndex = i + 1;
                        road = road + diff1;

                    } else if (diff22 > diff11) {
                        secondFingerIndex = i + 1;
                        road = road + diff2;
                    } else {
                        firstFingerIndex = i + 1;
                        road = road + diff1;
                    }
                } else {
                    firstFingerIndex = i + 1;
                    road = road + diff1;
                }
            }
        }

        return road;
    }

}
