package 动态规划;

import java.util.Arrays;

/*
*       题目：给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。计算并返回可以凑成
*       总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。你可以认为每种硬币的数量是无限的。
*       输入：coins = [1, 2, 5], amount = 11
*       输出：3
*       解释：11 = 5 + 5 + 1
*
*       输入：coins = [2], amount = 3
*       输出：-1
*
*       输入：coins = [1], amount = 0
*       输出：0
* */

/*
*       题解：分析，假设全部由一元硬币进行兑换，所需硬币数最多为 amount 个（钱数），思考过程会发现在到达最终答案前会有两个影响
*       但当前值，即  钱数和硬币个数 ，定义dp[amount + 1]数组，数组角码表示当前已找零的钱数，数值维护 硬币个数 ，我们需要维护
*       dp值为组成当前数值钱数所需的最少硬币数，对于dp[i]有：dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
*       dp数组的初始化，dp[0] = 0;(钱数为0，需要零个硬币)   其他dp数值更新为  amount + 1（保证初次dp更新成立）
*
*       dp数组的更新方式，两层循环嵌套，外层循环遍历从1 到 amount，表示钱数由小递增的过程，内层循环遍历所有硬币种类，
*       若此硬币数值小于当前钱数，表示当前钱数可用此硬币对其进行替换，然后对dp值通过上面的状态转移方程进行更新
*       循环完成，返回值判断，若dp[amount] == amount + 1,表示所需硬币数不合理，即无法找零，返回 -1，
*                         反之则返回dp[amount];
* */


public class Code_322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }
}
