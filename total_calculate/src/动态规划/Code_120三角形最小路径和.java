package 动态规划;

import java.util.List;

/**
*       题目：给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *      每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *      也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *      输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 *      输出：11
 *       2
 *      3 4
 *     6 5 7
 *    4 1 8 3
* */

/*
*       题解：定义dp数组记录到达当前层时每一位所需的最小路径，定义n记录自己处于那一层，且本层含有的元素也为n，对于dp数组有：dp[i](i < n)
*           若i == 0，即处于本层的第一个元素，则对于它来说，它只能从上一层的首元素下来，所以有：dp[i] = triangle.get(n - 1).get(i) + dp[i];
*           若i == n - 1,即处于本层最后一个元素，则对它来说，它只能从上一层的末元素下来，所以有：dp[i] = triangle.get(n - 1).get(i) + dp[i - 1];
*           若i为中间元素，则其从上一层有两条路径下来，一是将其与上层对齐后的i号，另一是i - 1号元素，由于我们需要维护小值，所以从上面两者中dp值
*           小的一个下来，有：dp[i] = Math.min(dp[i - 1], dp[i]) + triangle.get(n - 1).get(i);
*           对于上dp维护过程我们发现，dp记录的是到达本层时的最小值，对于本层来说，本层dp的维护需要上层的dp值，所以在本层dp值全部求出前我们不能更该
*           上层dp值，假如我们对dp数组修改，那么此时它将记录本层的dp值，我们也就丢失了上层的dp值，那么此时如若需要用的上层dp值已被修改，则会出错，
*           所以我们定义中转数组dp1，让其记录本层的dp值，当本层全部维护完成后，用dp1的值刷新dp数组，表示动规的层数下移。
*           通过两层循环遍历三角形更新dp数组，遍历完三角形，求取dp数组的最小值，返回
* */
public class Code_120三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[len];
        int[] dp1 = new int[len];
        int n = 1;
        while (n <= len) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp1[i] = triangle.get(n - 1).get(i) + dp[i];
                } else if (i == n - 1) {
                    dp1[i] = triangle.get(n - 1).get(i) + dp[i - 1];
                } else {
                    dp1[i] = Math.min(dp[i - 1], dp[i]) + triangle.get(n - 1).get(i);
                }
            }
            if (n >= 0) System.arraycopy(dp1, 0, dp, 0, n);
            n++;
        }
        int min = dp[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
