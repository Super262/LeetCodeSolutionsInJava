package Solutions;

public class Problem0260 {
    public int[] singleNumber(int[] nums) {
        int allXOR = 0;
        for (int x : nums) {
            allXOR ^= x;
        }
        int k = 0;
        while ((allXOR & 1) == 0) {
            allXOR >>= 1;
            ++k;
        }
        return new int[]{findKthEquals(nums,k,0),findKthEquals(nums,k,1)};
    }

    private int findKthEquals(int[] nums,final int k,final int val) {
        int result = 0;
        for (int x : nums) {
            if (((x >> k) & 1) == val) {
                result ^= x;
            }
        }
        return result;
    }
}
