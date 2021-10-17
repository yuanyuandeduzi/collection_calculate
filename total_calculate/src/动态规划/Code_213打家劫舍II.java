package 动态规划;

/*
 *   你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 *   同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。给定一个代表每个房屋存放金额的非负整数数组，
 *   计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *   输入：nums = [2,3,2]
 *   输出：3
 *   输入：nums = [1,2,3,1]
 *   输出：4
 * */

/*
 *   自己的解题思路：房子首尾项链所以需要分情况，可以选择从的区间为[0,n-1]或者[1,n],对这两段使用打家劫舍一的动规思路分别求出两段所能投到的最大值，然后
 *  进行比较，其中大的值就是所能偷到的最大值，然后进行边界判断，小于三件的情况自己算出进行返回。
 *  在[0,n-1] 区间初始化dp数组为 dp[0] = nums[0]; dp[1] = nums[1]; dp[2] = nums[0] + nums[1];
 *  在[1,n]区间初始化dp数组为 dp2[1] = nums[1];dp2[2] = nums[2];  dp2[3] = nums[1] + nums[3];
 *  状态转移方程： dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i]);
 * */

/*
 *  官方的解题思路：将房子分为两个区间，可以选择从的区间为[0,n-1]或者[1,n],每段使用打家劫舍一思路然后对两段分别求其最大值返回两端中大的
 *
 *  */

public class Code_213打家劫舍II {
    public int robM(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (n == 3) {
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
            return max;
        } else {
            int[] dp1 = new int[n - 1];
            dp1[0] = nums[0];
            dp1[1] = nums[1];
            dp1[2] = nums[0] + nums[2];
            for (int i = 3; i < n - 1; i++) {
                dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + nums[i];
            }
            int max1 = Math.max(dp1[n - 2], dp1[n - 3]);
            int[] dp2 = new int[n];
            dp2[1] = nums[1];
            dp2[2] = nums[2];
            dp2[3] = nums[1] + nums[3];
            for (int i = 4; i < n; i++) {
                dp2[i] = Math.max(dp2[i - 2], dp2[i - 3]) + nums[i];
            }
            int max2 = Math.max(dp2[n - 1], dp2[n - 2]);
            return Math.max(max1, max2);
        }
    }

    public int robG(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp1 = new int[n - 1];
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n - 1; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            }
            int max1 = dp1[n - 2];
            int[] dp2 = new int[n];
            dp2[1] = nums[1];
            dp2[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < n; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
            }
            int max2 = dp2[n - 1];
            return Math.max(max1, max2);
        }
    }
}
