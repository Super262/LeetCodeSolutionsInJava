package Solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem0341 {
    public static class NestedIterator implements Iterator<Integer> {

        private final LinkedList<NestedInteger> stack = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            stack.addAll(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return stack.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.getFirst().isInteger()) {
                List<NestedInteger> front = stack.removeFirst().getList();
                while (!front.isEmpty()) {
                    stack.addFirst(front.remove(front.size() - 1));
                }
            }
            return !stack.isEmpty();
        }
    }
}
