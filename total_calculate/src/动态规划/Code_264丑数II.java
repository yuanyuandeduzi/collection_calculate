package 动态规划;

/*
*       题目：给你一个整数 n ，请你找出并返回第 n 个 丑数 。
*       丑数 就是只包含质因数 2、3 和/或 5 的正整数。
*
*       输入：n = 10
*       输出：12
*       解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
*
*       输入：n = 1
*       输出：1
*       解释：1 通常被视为丑数。
* */

/*
*       题解：定义dp数组记录当前位的丑数值，定义三个指针p2,p3,p5,表示下一丑数乘以对应的质因数产生，如果是
*       p2指针则乘以2,以此类推，初始话指针都为0，dp[0]为1，dp[i]的维护方程为
*           nums1 = dp[p2] * 2;
*           nums2 = dp[p3] * 3;
*           nums3 = dp[p5] * 5;
*           dp[i] = Math.min(nums1, Math.min(nums2, nums3));
*       当前dp位数值由哪个指针产生，则此指针前移一位，如 p2++,此举会保证由当前三个指针产生的值大于dp[i - 1]
*       且dp值为更新为三者最小值，然后前移产生此值的指针
*       解释:假如dp[i - 1]由p2产生，p2++,下一值p2产生值大于dp[i-1]
*           由于更新值为p2更新的值，所以p3,p5下一产生的值本就大于dp[i-1]
* */

public class Code_264丑数II {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int nums1, nums2, nums3;
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            nums1 = dp[p2] * 2;
            nums2 = dp[p3] * 3;
            nums3 = dp[p5] * 5;
            dp[i] = Math.min(nums1, Math.min(nums2, nums3));
            if(nums1 == dp[i]) {
                p2++;
            }
            if(nums2 == dp[i]) {
                p3++;
            }
            if(nums3 == dp[i]) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
