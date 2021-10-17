package 动态规划;

/*
*       题目：在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
*       输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
*       输出：4
*       输入：matrix = [["0","1"],["1","0"]]
*       输出：1
* */

/*
*       解题思路：定义二维dp数组用于记录每个点随能围成的最大的正方形的边长，当前点的边长数可由与之相邻的右上三个
*       dp数组的值推出，状态转方程为：
*       若此点为‘1’
*       dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
*       若此点不为‘0’
*       dp[i][j] = 0;
*       由于此dp数组的启动值与i-1有关，所以需要对dp[0][j]和dp[i][0]两列进行初始化，若为'1'则初始化值为1，若为
*       ‘0’则初始化为0
*       定义ans用于记录全图中边长最大的边数，绥中返回ans * ans。
* */

public class Code_221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int width = matrix[0].length;
        int length = matrix.length;
        int[][] dp = new int[length][width];
        int ans = 0;
        for(int i = 0; i < width; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                ans = 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for(int i = 1; i < length; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                ans = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < length; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    ans = Math.max(ans , dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }

        }
        return ans * ans;
    }
}
