package 动态规划;

/*
*
*       题目：给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点 i 和 j
*        之间的距离为j - i。一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，
*       也就是景点的评分之和 减去 它们两者之间的距离。返回一对观光景点能取得的最高分。
*       输入：values = [8,1,5,2,6]  输出：11
*       输入：values = [1,2]  输出：2
* */
/*
*       理解：新的解题思路，对于有公式的动规问题可将公式于当前所维护的东西进行联系，将复杂公式简单化，对所给公式进行分割，
*       对于对所维护点，其点的索引仅为常量
*       题解：将观光组合的得分的公式进行分割，values[i] + i 和values[j] - j,对于第j位观光点来说，values[j] - j
*       是一恒定不变的值，所以此点的最大值取决于此点之前点中values[i] + i的最大值，所一定义max用于维护到达此点
*       过程中values[i] + i的最大值，然后定义ans维护最给得分，最终遍历完数组，返回ans值
 * */

public class Code_1014最佳观光组合 {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, max = values[0];
        for(int i = 1; i < values.length; i++) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}
