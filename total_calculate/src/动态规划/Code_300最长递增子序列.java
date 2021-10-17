package 动态规划;

/*
*       题目：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。子序列是由数组派生
*       而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是
*       数组 [0,3,1,6,2,2,7] 的子序列。
*       输入：nums = [10,9,2,5,3,7,101,18]
*       输出：4
*       解释：最长递增子序列是 [2,3,7,101]，因此长度为4。
*       输入：nums = [0,1,0,3,2,3]
*       输出：4
* */

/*
*       题解：定义dp数组，dp数组用于维护此位的从数组头到此位的最长递增子序列的长度，初始划dp数组
*       全为1,因为自己一个长度即为1了
*       状态转移方程：dp[i] = Math.max(dp[i], dp[j] + 1); （0 < j <= i）;
*       这里会对从头到此位的所有数组元素进行判断，若此位大于此数组员素则表示此为可以添加至此位的子
*       序列后，所以此位的 dp[j]加一与dp[i]比较取大值为此位的dp值，遍历完全得到此位的dp值，每次
*       得到新的dp值维护ans为dp最大值
*
* */

public class Code_300最长递增子序列 {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
