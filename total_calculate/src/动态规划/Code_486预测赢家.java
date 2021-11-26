package 动态规划;

/**
 *       题目：给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。玩家 1 和玩家 2 轮流进行自己的回合，
 *       玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），
 *      取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *      如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 *      你可以假设每个玩家的玩法都会使他的分数最大化。
 * */

/*
 *       题解：定义dp[len][len]数组，表示当作为先手，在区间nums[i...j]里进行所能获得的净胜分，所以我们只要找到在区间[0,len]上
 *       的净胜分是否大于零，即可得出先选者能否获胜。
 *       状态转移方程为： dp[i][j] = Math.max(nums[i] - dp[i + 1][j],nums[j] - dp[i][j - 1]);
 *       循环遍历数组更新dp数组，最终求出答案。
 * */

public class Code_486预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for(int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for(int j = 1; j < len; j++) {
            for(int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}

