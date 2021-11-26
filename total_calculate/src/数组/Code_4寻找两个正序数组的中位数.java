package 数组;

/**
*       题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *      输入：nums1 = [1,3], nums2 = [2]
 *      输出：2.00000
 *      解释：合并数组 = [1,2,3] ，中位数 2
* */

/*
*       题解：我们可以将两个数组合并，然后寻找其中位数，我们可以将转换为寻找第K个数，定义len表示合并后数组的长度，
*       若为奇数，我们只需要知道(len + 1) / 2即可，遍历次数为(len / 2 + 1)次，若为偶数，则需要知道len / 2
*       和len / 2 + 1项，也需要遍历(len / 2 + 1)。
*       返回中位数，对于奇数我们只需要返回最后一次遍历的数即可，而偶数我们需要最后一次遍历的数和上一次遍历的数，所以
*       我们用一个数来记录上一次的值。
*       遍历过程为，由于两个数组有序，所以定义两个指针，aStart,bStart分别指向两个数组，每次遍历比较两个指针所致的
*       两数组的值，将小的数的指针前移一位，边界处理：当两数组中有意个数组为空时，此时只移动不为空的那个数组的指针。
*       整体判断逻辑：aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])
*       最后根据len的奇偶数返回ans.
*  */

public class Code_4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int bStart = 0;
        int left = 0,right = 0;
        int aStart = 0;
        for(int i = 0; i <= len / 2; i++) {
            left = right;
            if(aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if(len % 2 != 0) {
            return right;
        }else {
            return (right + left) / 2.0;
        }
    }
}
