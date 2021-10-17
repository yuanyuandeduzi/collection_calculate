package 动态规划;


import java.util.HashSet;
import java.util.List;

/*
*       题目：给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
*       说明：
*       拆分时可以重复使用字典中的单词。
*       你可以假设字典中没有重复的单词。
*       输入: s = "leetcode", wordDict = ["leet", "code"]
*       输出: true
*       解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
*
*       输入: s = "applepenapple", wordDict = ["apple", "pen"]
*       输出: true
*       解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。  注意你可以重复使用字典中的单词。
* */

/*
*       题解：定义boolean型dp数组，用于记录字符串当前位之前的能否由字典内元素组成，初始化dp[0] = true;
*       我们需要枚举所有长度的字符串子串去判断这个子串能不能由字典内元素组成，用于维护dp数组，所以我们设置外
*       层循环用于枚举所有长度可能，内层循环判断当前字符子串能否由字典内元素组成，判断流程：将子串所有分割形
*       式进行尝试，分割点为j(j > 0. j < 子串长度)，当前子串分割后可形成两段，前段可通过dp[j]判断，后段
*       在字典中进行匹配，若两者均符合则表示当前子串可以组成，即dp[i] = true;退出内层循环，尝试下一长度，
*       以此更新dp数组，最后返回dp[len],表示由头开始长度为len的字符串子串（即字符串本身可由字典元素构成）
* */

public class Code_139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length() + 1;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
