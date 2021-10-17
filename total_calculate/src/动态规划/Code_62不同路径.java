package 动态规划;

/*
*       题目：一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只
*       能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
*       问总共有多少条不同的路径？
*       输入：m = 3, n = 7  输出：28  输入：m = 3, n = 2  输出：3
* */
/*
*       题解：定义二维dp数组，用于与图匹配记录机器人走到当前位置择偶难公共有多少种可能，有题知机器人只
*       能想下下个右走，所以状态转移方程为  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
*       初始化dp数组，对与dp[0][j]这一列来说没有i-1项，所以需要初始化，又由于对于这一列只能向右走
*       所以全部初始化为1，同理初始化dp[i][0]一列为1，然后遍历补充dp数组，返回dp[m-1][n-1]
* */

/*
*       题解：组合数学法：从左.上角到右下角的过程中，我们需要移动m + n - 2次，其中有m - 1次向下移动
*       n - 1次向右移动。因此路径的总数，就等于从m + n- 2次移动中选择m - 1次向下移动的方案数，即组合数:
*       C(m - 1) (m + n - 2) = ((m + n - 2) * (m + n - 3) * …… * n) / (m - 1)!
*       =(m + n - 2)!/(m-1)! * (n - 1)!   直接计算出可能路线的种类
* */

public class Code_62不同路径 {
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] +  dp[i][j - 1];
            }
        }
        System.out.println();
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
