package 动态规划;

/*
*       题目：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能
*       向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。现在考虑网格中有障
*       碍物。那么从左上角到右下角将会有多少条不同的路径？
* */

/*
*       题解Z：定义二维dp数组，用于与图匹配记录机器人走到当前位置择偶难公共有多少种可能，由题知机器人只
*       能向下，向右走，所以状态转移方程为  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
*       初始化dp数组，对与dp[0][j]这一列来说没有i-1项，所以需要初始化，由于对于这一列只能向右走
*       所以全部初始化为1，如若遇见障碍则表示无法在向后走，初始化后面的值为0，同理初始化dp[i][0]，
*       然后遍历补充dp数组，返回dp[m-1][n-1]
* */

/*
*       题解G:定义一个一维数组f用于记录记录每层的dp数据，由于dp数据的维护只与其上层同位置dp数据和f(i-1),
*       当前位是否为障碍有关，若有关则此位直接为0，否则 f[i] += f[i-1],
*       f 的初始化为f[0]  = obstacleGrid[0][0] == 0 ? 1 : 0;
*       遍历完全数组，返回f[n][m];
* */


public class Code_63不同路径II {
    public int uniquePathsWithObstaclesZ(int[][] obstacleGrid) {
        int with = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        int[][] dp = new int[height][with];
        int n = 0;
        for(int i = 0; i < with; i++) {
            if(obstacleGrid[0][i] != 1 && n == 0) {
                dp[0][i] = 1;
            }else {
                n = 1;
                dp[0][i] = 0;
            }
        }
        n = 0;
        for(int i = 0; i < height; i++) {
            if(obstacleGrid[i][0] != 1 && n == 0) {
                dp[i][0] = 1;
            }else {
                n = 1;
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < height; i++) {
            for(int j = 1; j < with; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[height-1][with-1];
    }

    public int uniquePathsWithObstaclesG(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
