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

class RandomizedSet4 {
    private final Map<Integer, Integer> map;
    private final List<Integer> array;

    /** Initialize your data structure here. */
    public RandomizedSet4() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int index = array.size();
            array.add(val);
            map.put(val, index);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index != null) {
            int lastVal = array.get(array.size() - 1);
            if (lastVal != val) {
                array.set(index, lastVal);
                map.put(lastVal, index);
            }
            array.remove(array.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = array.size();
        if (size == 0) {
            return 0;
        }
        int index = new Random().nextInt(size);
        return array.get(index);
    }
}
