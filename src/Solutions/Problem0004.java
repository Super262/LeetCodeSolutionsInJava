package Solutions;

public class Problem0004 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int n = (nums1 == null ? 0 : nums1.length) + (nums2 == null ? 0 : nums2.length);
        if (n % 2 == 0) {
            return (double) (findKth(nums1,0,nums2,0,n / 2) + findKth(nums1,0,nums2,0,n / 2 + 1)) / 2.0;
        } else {
            return (double) findKth(nums1,0,nums2,0,n / 2 + 1);
        }
    }

    private int findKth(int[] sortedArr1,int start1,int[] sortedArr2,int start2,int k) {
        if (sortedArr1 == null || start1 >= sortedArr1.length) {
            return sortedArr2[start2 + k - 1];
        }
        if (sortedArr2 == null || start2 >= sortedArr2.length) {
            return sortedArr1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(sortedArr1[start1],sortedArr2[start2]);
        }
        int halfKOfArr1 = start1 + k / 2 - 1 < sortedArr1.length ? sortedArr1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKOfArr2 = start2 + k / 2 - 1 < sortedArr2.length ? sortedArr2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfKOfArr2 > halfKOfArr1) {
            return findKth(sortedArr1,start1 + k / 2,sortedArr2,start2,k - k / 2);
        } else {
            return findKth(sortedArr1,start1,sortedArr2,start2 + k / 2,k - k / 2);
        }
    }
}
