package 数组;

import java.util.Arrays;

/*
*      解题思路：将nums2数组的至放入nums1中，然后对其进行排序
*
* */

public class Code_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
