package 递归;

import java.util.ArrayList;
import java.util.List;

/**
*       题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。（九键输入）
 *      输入：digits = "23"
 *      输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *      输入：digits = "2"
 *      输出：["a","b","c"]
 * */

/*
*       题解：此题类似于全排列问题，只是不牵扯值的重新使用问题，所以通过递归回溯解决字母的排列组合问题，
*       定义递归方法dfs(String digits, String ss, int n, int m),表示输入长度为m的数字，为第
*       n位依次放置第n位对应的字母，digits为输入数字，ss为当前以组合的字符串。
*       递归方法的退出条件，若n == m,表示所有位都有字母对应了，此时将此ss加入集合。退出递归方法。
* */

public class Code_17电话号码的字母组合 {
    private List<String> ans = new ArrayList<>();
    private String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        dfs(digits,"",0,digits.length());
        return ans;
    }

    private void dfs(String digits, String ss, int n, int m) {
        if (n == m) {
            if(!ss.equals(""))
                ans.add(ss);
            return;
        }
        String s = arr[Integer.parseInt(digits.charAt(n) + "") - 2];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String s1 = ss;
            s1 += aChar;
            dfs(digits, s1, n + 1, m);
        }
    }
}
