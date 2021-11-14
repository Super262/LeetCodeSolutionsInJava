package Solutions;

public class Problem0324 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 选取中位数或者中位数左侧较小的元素相当于选取第(nums.length - 1) / 2 + 1个元素（从1开始计数）
        int smallerMid = partitionBySmallerMid(nums,0,nums.length - 1,(nums.length - 1) / 2 + 1);
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            answer[i] = smallerMid;
        }
        int left = 1;
        int right = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        for (int num : nums) {
            if (num > smallerMid) {
                answer[left] = num;
                left += 2;
            } else if (num < smallerMid) {
                answer[right] = num;
                right -= 2;
            }
        }
        System.arraycopy(answer,0,nums,0,answer.length);
    }

    private int partitionBySmallerMid(int[] nums,int start,int end,int k) {
        if (start >= end) {
            return nums[start];
        }
        int pivot = nums[start + (end - start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                ++i;
            }
            while (i <= j && nums[j] > pivot) {
                --j;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
                --j;
            }
        }
        if (start + k - 1 <= j) {
            return partitionBySmallerMid(nums,start,j,k);
        }
        if (start + k - 1 >= i) {
            return partitionBySmallerMid(nums,i,end,k - (i - start));
        }
        return nums[j + 1];
    }
}
