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

class RandomizedSet2 {
    private final Map<Integer, Integer> map;
//    private final Integer[] array;
    private final List<Integer> array;
//    private Integer size;

    /** Initialize your data structure here. */
    public RandomizedSet2() {
        map = new HashMap<>();
//        array = new Integer[100];
        array = new ArrayList<>(100);
//        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int index = array.size();
            map.put(val, index);
            array.add(val);
//            array[size] = val;
//            size += 1;
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer v = map.get(val);
        if (v != null) {
            map.remove(val);
            array.remove((int) v);
//            array[v] = null;
//            size -= 1;
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
//        long currentTimeMillis = System.currentTimeMillis();
//        int index = (int) (currentTimeMillis % size);
        int index = new Random().nextInt(size);
        return array.get(index);
//        return array[index];
    }
}
