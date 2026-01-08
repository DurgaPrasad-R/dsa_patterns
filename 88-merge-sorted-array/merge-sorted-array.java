class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        int i1 = m - 1;
        int i2 = n - 1;

        while (i2 >= 0) {
            if (i1 >= 0 && nums1[i1] > nums2[i2]) {
                nums1[curr] = nums1[i1];
                i1--;
            } else {
                nums1[curr] = nums2[i2];
                i2--;
            }
            curr--;
        }
    }
}