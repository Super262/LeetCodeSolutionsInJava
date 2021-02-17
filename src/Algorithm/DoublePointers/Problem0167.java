package Algorithm.DoublePointers;

public class Problem0167 {
    public int[] twoSum(int[] numbers,int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[2];
        }
        int i = 0;
        int j = numbers.length - 1;
        int tempSum;
        while (i < j) {
            tempSum = numbers[i] + numbers[j];
            if (tempSum == target) {
                return new int[]{i + 1,j + 1};
            } else if (tempSum > target) {
                --j;
            } else {
                ++i;
            }
        }
        return new int[2];
    }
}
