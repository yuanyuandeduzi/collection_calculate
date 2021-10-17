package 动态规划;

/*
*       题目：超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。给你一个整数 n
*       和一个整数数组 primes ，返回第 n 个 超级丑数 。题目数据保证第 n 个 超级丑数 在 32-bit 带
*       符号整数范围内。
*       输入：n = 12, primes = [2,7,13,19]
*       输出：32
*       输入：n = 1, primes = [2,3,5]
*       输出：1
* */

/*
*       解题思路：解题思路与丑数II一致，知识此时的质因数的个数变为质因数数组的个数，所以我们定义一个数组
*       用于存储指针，指针表示下一丑数由指针所指丑数乘以对应的质因数产生，定义num数组记录当前位产生的丑数
*       dp[i]数组的维护为num数组的最小值，然后遍历num数组，判断num值是否为dp[i],将产生当前丑数的值的
*       指针前移一位，具体原因详见丑数II
* */

public class Code_313超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length];
        int[] num = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int minNum = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                num[j] = dp[p[j]] * primes[j];
                minNum = Math.min(num[j], minNum);
            }
            dp[i] = minNum;
            for(int j = 0; j < primes.length; j++) {
                if(num[j] == dp[i]) {
                    p[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
