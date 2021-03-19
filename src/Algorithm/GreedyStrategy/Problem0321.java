package Algorithm.GreedyStrategy;

public class Problem0321 {
    public int[] maxNumber(int[] nums1,int[] nums2,int k) {
        int[] result = new int[k];
        int part1Len = Math.max(0,k - nums2.length);
        int part2Len;
        int[] temp;
        while (part1Len <= nums1.length && part1Len <= k) {
            part2Len = k - part1Len;
            temp = mergeSeqsToLargest(maxSubsequence(nums1,part1Len),maxSubsequence(nums2,part2Len));
            ++part1Len;
            if (compareNumbers(temp,0,result,0) > 0) {
                System.arraycopy(temp,0,result,0,k);
            }
        }
        return result;
    }

    private int[] maxSubsequence(int[] nums,int k) {
        int[] stack = new int[k];
        int stackTop = -1;
        int remainsCount = nums.length - k;
        for (int num : nums) {
            while (stackTop >= 0 && remainsCount > 0 && stack[stackTop] < num) {
                --stackTop;
                --remainsCount;
            }
            if (stackTop < k - 1) {
                stack[++stackTop] = num;
            } else {
                --remainsCount;
            }
        }
        return stack;
    }

    private int[] mergeSeqsToLargest(int[] seq1,int[] seq2) {
        int[] result = new int[seq1.length + seq2.length];
        int p1 = 0;
        int p2 = 0;
        int pr = 0;
        while (p1 < seq1.length && p2 < seq2.length) {
            if (compareNumbers(seq1,p1,seq2,p2) > 0) {
                result[pr++] = seq1[p1++];
            } else {
                result[pr++] = seq2[p2++];
            }
        }
        while (p1 < seq1.length) {
            result[pr++] = seq1[p1++];
        }
        while (p2 < seq2.length) {
            result[pr++] = seq2[p2++];
        }
        return result;
    }

    private int compareNumbers(int[] num1,int start1,int[] num2,int start2) {
        int l1 = num1.length - start1;
        int l2 = num2.length - start2;
        int commonL = Math.min(l1,l2);
        for (int i = 0; i < commonL; ++i) {
            if (num1[start1 + i] == num2[start2 + i]) {
                continue;
            }
            return num1[start1 + i] - num2[start2 + i];
        }
        return l2 - l1;
    }
}
