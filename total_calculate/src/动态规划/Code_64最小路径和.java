package 动态规划;

/*
*       题目：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路
*       径上的数字总和为最小。说明：每次只能向下或者向右移动一步。
*       输入：grid = [[1,3,1],[1,5,1],[4,2,1]]  输出：7
*       输入：grid = [[1,2,3],[4,5,6]]  输出：12
* */

/*
*       题解：由于每次只能向下下或向右移动一步，所一当前位的最小和为它上面和它左边种小的值加上自身的点数
*       定义dp[m][n]数组用于维护当前位的最小值和，
*       状态转移方程为：dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]; i > 0, j > 0;
*       由于dp数组需要前一位进行更新当前值，所以初始化dp[0][n]和的dp[m][0]两列，
*       初始化发方程为：dp[0][j]=dp[0][j−1]+grid[0][j] 和 dp[i][0]=dp[i−1][0]+grid[i][0]
*       遍历数组，更新dp数组，最终返回最右下角值
* */

public class Code_64最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
