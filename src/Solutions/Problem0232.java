package Solutions;

import java.util.Stack;

public class Problem0232 {
    class MyQueue {
        private final Stack<Integer> storage;
        private final Stack<Integer> temp;

        public MyQueue() {
            storage = new Stack<>();
            temp = new Stack<>();
        }

        public void push(final int x) {
            storage.push(x);
        }

        public int pop() {
            while (!storage.empty()) {
                temp.push(storage.pop());
            }
            int t = temp.pop();
            while (!temp.empty()) {
                storage.push(temp.pop());
            }
            return t;
        }

        public int peek() {
            while (!storage.empty()) {
                temp.push(storage.pop());
            }
            int t = temp.peek();
            while (!temp.empty()) {
                storage.push(temp.pop());
            }
            return t;
        }

        public boolean empty() {
            return storage.empty();
        }
    }
}
