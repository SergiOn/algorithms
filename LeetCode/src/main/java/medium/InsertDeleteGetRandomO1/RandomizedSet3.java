package medium.InsertDeleteGetRandomO1;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedSet3 {
    private final Map<Integer, Integer> map;
    private final Integer[] array;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet3() {
        map = new HashMap<>();
        array = new Integer[5000];
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int index = size;
            array[index] = val;
            map.put(val, index);
            size += 1;
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index != null) {
            int lastVal = array[size - 1];
            if (lastVal != val) {
                array[index] = lastVal;
                map.put(lastVal, index);
            }
            array[size - 1] = null;
            map.remove(val);
            size -= 1;
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (size == 0) {
            return 0;
        }
        int index = new Random().nextInt(size);
        return array[index];
    }
}
