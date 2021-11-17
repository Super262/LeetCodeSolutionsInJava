package Solutions;

public class Problem0287 {
    // 类似环形链表找入口
    public int findDuplicate(int[] nums) {
        int a = 0;
        int b = 0;
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (b == nums.length || a == nums.length) {
                break;
            }
            if (a == b) {
                a = 0;
                while (a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
        return -1;
    }
}
