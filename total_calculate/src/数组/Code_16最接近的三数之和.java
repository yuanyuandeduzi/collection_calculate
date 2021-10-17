package 数组;

import java.util.Arrays;

/*
*       题目：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
*       使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
*       输入：nums = [-1,2,1,-4], target = 1
*       输出：2
*       解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
* */

/*
*       题解：对于此种数组中元素取几个求和，我们需要美剧出所有可能求出解，但暴力枚举具有较大的时间复杂度
*       所以一般采用定一双指针法，
*       本题，由于与数值有关,先排序,定一，定义指针L,R，分别指向所定一后的数组范围的两边，通过循环将此定
*       一目标的所有可能枚举出来定义sum记录三数之和，每次求和更新ans，将sum与target比较，若相等则直接
*       返回ans，若sum小于target，则表示小，由于已经排序，所以左指针右移，sum 变大，否则则相反
*       定一完所有元素，返回ans
* */

public class Code_16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int L, R, ans = 1000000, sum;
        for(int i = 0; i < nums.length - 2; i++) {
            L = i + 1;
            R = nums.length - 1;
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            while(L < R) {
                sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
                if(sum - target == 0) {
                    return ans;
                }else if(sum - target < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }
        return ans;
    }
}