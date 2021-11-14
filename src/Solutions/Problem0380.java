package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Problem0380 {
    private static class RandomizedSet {

        private final ArrayList<Integer> data;
        private final HashMap<Integer, Integer> value2Index;
        private final Random rand;

        public RandomizedSet() {
            data = new ArrayList<>();
            value2Index = new HashMap<>();
            rand = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (value2Index.containsKey(val)) {
                return false;
            }
            data.add(val);
            value2Index.put(val,data.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!value2Index.containsKey(val)) {
                return false;
            }
            int currentIndex = value2Index.get(val);
            int lastValue = data.get(data.size() - 1);

            data.set(currentIndex,lastValue);
            value2Index.put(lastValue,currentIndex);

            value2Index.remove(val);
            data.remove(data.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return data.get(rand.nextInt(data.size()));
        }
    }
}
