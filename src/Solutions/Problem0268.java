package Solutions;

public class Problem0268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int allSum = 0;
        for (int x : nums) {
            allSum += x;
        }
        return (n + 1) * n / 2 - allSum;
    }
}
