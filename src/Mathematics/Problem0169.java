package Mathematics;

public class Problem0169 {
    public int majorityElement(int[] nums) {
        int result = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                result = num;
                ++votes;
            } else {
                if (num == result) {
                    ++votes;
                } else {
                    --votes;
                }
            }
        }
        return result;
    }
}
