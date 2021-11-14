package Solutions;

import java.util.Stack;

public class Problem0735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 1 || asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            boolean comingAsExploded = false;
            while (!stack.empty() && stack.peek() > 0 && as < 0) {
                int asRight = stack.peek();
                int asLeft = -as;
                if (asRight == asLeft) {
                    comingAsExploded = true;
                    stack.pop();
                    break;
                } else if (asRight < asLeft) {
                    stack.pop();
                    comingAsExploded = false;
                } else {
                    comingAsExploded = true;
                    break;
                }
            }
            if (!comingAsExploded) {
                stack.push(as);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return result;
    }
}
