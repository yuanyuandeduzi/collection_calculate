package 字符串;

/**
*       题目：句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 *      例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 *      给你一个句子 s 和一个整数 k，请你将 s 截断 ,使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 *
 *      输入：s = "Hello how are you Contestant", k = 4
 *      输出："Hello how are you"
 *  */

/*
*       题解：此题可以通过正常分割后在拼接实现，还可以通过一次遍历寻找第 k 个空格的位置，而第 k 个空格之前将含有 k 个单词，若句子中含有
*       的空格不足 k 个，即句子中正好只含有 k 个单词，此时只存在 k - 1 个空格，此时返回完整的句子。
*
* */

public class Code_1816截断句子 {
    public String truncateSentence(String s, int k) {
        int n = 0;
        while(k != 0 && n < s.length()) {
            if(s.charAt(n) == ' ') {
                k--;
            }
            n++;
        }
        return s.substring(0,n).trim();
    }
}
