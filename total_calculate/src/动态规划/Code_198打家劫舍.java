package 动态规划;

/*  打家劫舍
*   你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
*   给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
*   输入：[1,2,3,1]
*   输出：4
*
*   输入：[2,7,9,3,1]
*   输出：12
* */

/*
*   自己的解题思路：（维护每间房子都偷的情况下的所能偷到的最大值）动态规划：创建动规数组dp,由于偷当前房间就不能偷前一房间，
*   所以第n间房间与第n-2和n-3间房间的最大值相关，初始化dp数组
*   dp[0] = nums[0]; dp[1] = nums[1]; dp[2] = nums[0] + nums[1];
*   状态转移方程： dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i]);
*   将只有小于等于3房间的时的值直接返回，之后通过循环未胡dp数组，知道遍历完全房间，在遍历完全后返回最后两间房子的最大值，因为最终会是
*   偷这两间房子中的一个结束。返回值为：Math.max(dp[nums.length-1], dp[nums.length-2]);
* */

/*
*   官方的解题思路：（维护当前房子所能偷到的最大值，两种状态，偷与不偷）  动态规划：边界控制，只有一件房屋，则偷该房屋，两间房屋时，偷其中金额高的那个
*   边界条件为：dp[0]=nums[0]，dp[1] = dp[1] = Math.max(nums[0],nums[1]);
*   状态转移方程为：dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
*   分析：对于第n房屋来说，存在两种状态，偷与不偷，偷，其最大值则为n-2的最大值加上自身金额，不偷，则为n-1的最大值
* */

public class Code_198打家劫舍 {
    public int robM(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }else if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }else if(nums.length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }else {
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0] + nums[2];
            for(int i = 3; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i]);
            }
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
    //官方思路
    public int robG(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }else if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for(int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        return dp[nums.length - 1];
    }
}
