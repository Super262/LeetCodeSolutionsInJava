package Solutions;

public class Problem0088 {
    public void merge(int[] nums1,int m,int[] nums2,int n) {
        int resultTop = nums1.length - 1;
        --m;
        --n;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[resultTop--] = nums1[m--];
            } else {
                nums1[resultTop--] = nums2[n--];
            }
        }
        while (m >= 0) {
            nums1[resultTop--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[resultTop--] = nums2[n--];
        }
    }
}
