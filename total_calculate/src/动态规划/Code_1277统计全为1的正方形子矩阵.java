package 动态规划;


/*
*       题目：给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
*       输入：matrix =[[0,1,1,1],[1,1,1,1],[0,1,1,1]]
*       输出：15
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
*       此题与Code_221相似，我们通过观察会发现，dp数组不到维护最长边，而且维护将当前点加入后正方形所能增加的个数
*       （解释：由于是正方形，所以一当前位置，向外依次递增一，为，将当前调加入后所增加的正方形的个数，只需要关含有
*       该点的，因为不含该店的正方形的计算已被直线的计算所包含）
* */

public class Code_1277统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int width = matrix[0].length;
        int length = matrix.length;
        int[][] dp = new int[length][width];
        int ans = 0;
        for(int i = 0; i < width; i++) {
            if(matrix[0][i] == 1) {
                dp[0][i] = 1;
                ans += 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for(int i = 1; i < length; i++) {
            if(matrix[i][0] == 1) {
                dp[i][0] = 1;
                ans += 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < length; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    ans += dp[i][j];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
