package solutions.StackAndQueue;

public class Problem0042 {
    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        final int[] leftMaxH = new int[height.length];
        final int[] rightMaxH = new int[height.length];
        int result = 0;
        leftMaxH[0] = height[0];
        rightMaxH[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; ++i){
            leftMaxH[i] = Math.max(height[i], leftMaxH[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; --i){
            rightMaxH[i] = Math.max(height[i], rightMaxH[i + 1]);
        }
        for (int i = 0; i <height.length; ++i){
            result += (Math.min(leftMaxH[i], rightMaxH[i]) - height[i]);
        }
        return result;
    }
}
