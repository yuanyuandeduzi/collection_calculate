package 动态规划;

/*
*       题目：给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由 s1 和 s2 交错 组成的。两个字符串 s 和 t 交错 的定义与过程如下，
*       其中每个字符串都会被分割成若干 非空 子字符串：
*       输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
*       输出：true
*
*       输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
*       输出：false
* */

/*
*       题解：定义n,m,length分别记录s1,s2,s3的长度，进行先行判断，若m+n != length,则s3必不可能由s1,s2交错组成，直接返回false,若相等
*       则开始进行判断，定义f[n + 1][m + 1],f[i][j]表示当s3的匹配长度为i+j时，s1使用长度为i,s2使用长度为j,此长度的s3能否由s1,s2组成，
*       初始化f[0][0] = true，然后通过两层循环将两个子串的所有组合方式进行匹配，然后开始更新f数组，假使此时s2在第j位，对于s1的第i位来说，若
*       f[i-1][j]是否为true(表示s3长度为i-1+j时可以由s1的i-1和s2的j位错落组成),s1的第i位和s3的i+j位相等，则f[i][j] = true; 所以对于
*       s1的状态方程为 f[i][j] = f[i][j] || (f[i-1][j] && s3.charAt(p) == s1.charAt(i - 1));对于s2有相同的思路，s2的状态转移方程
*       为 f[i][j] = f[i][j] || (f[i][j - 1] && s3.charAt(p) == s2.charAt(j - 1));循环完成，返回f[n][m];
* */

public class Code_97交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int length = s3.length();
        if(n + m != length) {
            return false;
        }

        boolean f[][] = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if(i > 0) {     //当s1拿出长度不为0时
                    f[i][j] = f[i][j] || (f[i-1][j] && s3.charAt(p) == s1.charAt(i - 1));
                }
                if(j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s3.charAt(p) == s2.charAt(j - 1));
                }
            }
        }
        return f[n][m];
    }
}
