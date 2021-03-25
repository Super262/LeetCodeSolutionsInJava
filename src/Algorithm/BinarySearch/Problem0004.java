package Algorithm.BinarySearch;

public class Problem0004 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int n = (nums1 == null ? 0 : nums1.length) + (nums2 == null ? 0 : nums2.length);
        if (n % 2 == 0) {
            return (double) (findKth(nums1,nums2,n / 2) + findKth(nums1,nums2,n / 2 + 1)) / 2.0;
        } else {
            return (double) findKth(nums1,nums2,n / 2 + 1);
        }
    }

    private int findKth(int[] sortedArr1,int[] sortedArr2,int k) {
        if (sortedArr1 == null || sortedArr1.length == 0) {
            return sortedArr2[k - 1];
        }
        if (sortedArr2 == null || sortedArr2.length == 0) {
            return sortedArr1[k - 1];
        }
        int minValue = Math.min(sortedArr1[0],sortedArr2[0]);
        int maxValue = Math.max(sortedArr1[sortedArr1.length - 1],sortedArr2[sortedArr2.length - 1]);
        int midValue;
        while (minValue + 1 < maxValue) {
            midValue = minValue + (maxValue - minValue) / 2;
            if (countSmallerAndEqual(sortedArr1,midValue) + countSmallerAndEqual(sortedArr2,midValue) >= k) {
                maxValue = midValue;
            } else {
                minValue = midValue;
            }
        }
        if (countSmallerAndEqual(sortedArr1,minValue) + countSmallerAndEqual(sortedArr2,minValue) >= k) {
            return minValue;
        }
        return maxValue;
    }

    private int countSmallerAndEqual(int[] sortedArr,int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return 0;
        }
        int start = 0;
        int end = sortedArr.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (sortedArr[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (sortedArr[start] > target) {
            return start;
        }
        if (sortedArr[end] > target) {
            return end;
        }
        return sortedArr.length;
    }
}
