package Algorithm.Mathematics;

import java.util.Arrays;

public class Problem0238 {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        Arrays.fill(product,1);
        int left = 1;
        for (int i = 1; i < nums.length; ++i) {
            left *= nums[i - 1];
            product[i] *= left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            right *= nums[i + 1];
            product[i] *= right;
        }
        return product;
    }
}
