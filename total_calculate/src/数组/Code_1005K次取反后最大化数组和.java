package 数组;

import java.util.Arrays;

/**
*       题目：给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *          选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 *          重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *          以这种方式修改数组后，返回数组 可能的最大和 。
* */

/*
*       题解：通过控制k与负值的关系，加入存在负值，那么我们一定是将负值转换为正值后数组和大，所以先将数组升序排序，
*       此时负值将集中在前面了，方便负值转正。然后尝试将所有负值反转，若k比负值个数少，则在反转完成后直接返回数组和，
*       若反转完所有负数k值仍有剩余，此时判断剩余k奇偶，若为奇，则将最小的正数反转，若为偶则直接返回数组和。
* */

public class Code_1005K次取反后最大化数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = 0;
        while (k > 0 && n < nums.length && nums[n] < 0) {
            k--;
            nums[n] *= -1;
            n++;
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            ans += num;
            min = Math.min(min, num);
        }
        if (k % 2 != 0) {
            ans -= 2 * min;
        }
        return ans;
    }
}
