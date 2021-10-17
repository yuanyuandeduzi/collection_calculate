package 动态规划;

/*
*   题目：给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
*   输入：[2,3,-2,4]  输出：6  输入：[-2,0,-1]  输出：0
* */

/*
*   解题思路：分两个数组，一个维护当前子数组的最大值，一个维护当前子数组的最小值，维护最小值的作用，当前最小值为负数，加入下一数值
*   为负，则负负为正，成为最大正值，
*   状态转换方程为：fMax(i) = max{fMax(i-1)*nums[i],fMin[i-1] * nums[i], nums[i]}
*                fMax(i) = min{fMax(i-1)*nums[i],fMin[i-1] * nums[i], nums[i]}
*   遍历数组，求出max数组，遍历max数组，找到最大值返回
* */

public class Code_152乘积最大字数组 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for(int i = 1; i< length; i++) {
            maxF[i] = Math.max(maxF[i-1] * nums[i], Math.max(minF[i-1] * nums[i], nums[i]));
            minF[i] = Math.min(minF[i-1] * nums[i], Math.min(maxF[i-1] * nums[i], nums[i]));
        }
        int ans = maxF[0];
        for(int i = 1; i < length; i++) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
