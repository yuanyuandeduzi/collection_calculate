package 简单题;

import java.util.Arrays;

/**
*       题目：给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *      输入：nums = [3,0,1]
 *      输出：2
 * */


/*
*       题解：通过数学方法计算出n个数时从零至n的树的总和，然后遍历一边数组，用总和将数组中的每个值都减一次，
*       最终剩下的数值即为缺少的数字。
* */

public class Code_268丢失的数字 {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = (size + 1)  * size / 2;
        for(int i = 0; i < size; i++) {
            sum -= nums[i];
        }
        return sum;
     }
}
