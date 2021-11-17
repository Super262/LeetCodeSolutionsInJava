package Solutions;

import java.util.Iterator;

public class Problem0284 {
    class PeekingIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;
        private int current;
        private boolean nextExisted;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            nextExisted = iterator.hasNext();
            if (nextExisted) {
                current = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return current;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int t = current;
            nextExisted = iterator.hasNext();
            if (nextExisted) {
                current = iterator.next();
            }
            return t;
        }

        @Override
        public boolean hasNext() {
            return nextExisted;
        }
    }
}
