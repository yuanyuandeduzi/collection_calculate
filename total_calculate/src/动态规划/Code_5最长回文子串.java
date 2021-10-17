package 动态规划;

/*
*       题目：给你一个字符串 s，找到 s 中最长的回文子串。
*
*       输入：s = "babad"
*       输出："bab"
*       解释："aba" 同样是符合题意的答案。
*
*       输入：s = "cbbd"
*       输出："bb"
*
*       输入：s = "ac"
*       输出："a"
* */

/*
*       题解：定义boolean型二维dp[len][len]数组，len为字符串的长度，dp[i][j]的 i j 角码表示字符串从i到j此长度子串的状态，若为
*       true,则表示此段为回文子串，若为false则表示不是回文子串，然后定义begin记录最长回文字串的起始位置，定义maxLen记录最长回文子
*       串的长度，这两个值用于最后进行字符串的分割；
*       dp数组的维护方法：两层循环嵌套，外层循环用于枚举子串可能的长度，从2开始，len长结束，内城循环用于dp数组和begin,maxLen的维护
*       枚举当前长度的所有子串，我们将当前子串的最外面两个字符进行比较，若相同，此时判断当前子串的长度，若子串长度小于等于3，则当前子
*       串为回文子串，更新dp值，若大于，则dp值为：  dp[j][right] = dp[j + 1][right - 1];
*       最后判断当前dp值和当前子串长度与maxLen的关系，更新begin和maxLen，
*       循环完成，返回  s.substring(begin,begin + maxLen);
* */


public class Code_5最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }
        boolean[][] dp = new  boolean[len][len];
        int begin = 0;
        int maxLen = 1;
        for(int L = 2; L <= len; L++) {
            for(int j = 0; j < len; j++) {
                int right = j + L - 1;
                if(right >= len) {
                    break;
                }
                if(s.charAt(j) == s.charAt(right)) {
                    if(L <= 3) {
                        dp[j][right] = true;
                    }else {
                        dp[j][right] = dp[j + 1][right - 1];
                    }
                }else{
                    dp[j][right] = false;
                }
                if(dp[j][right] && maxLen < L) {
                    maxLen = L;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}
