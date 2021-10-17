package 递归;

import java.util.ArrayList;
import java.util.List;

/*
*       题目：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
*       有效括号组合需满足：左括号必须以正确的顺序闭合。
*
*       输入：n = 3
*       输出：["((()))","(()())","(())()","()(())","()()()"]
*
*       输入：n = 1
*       输出：["()"]
* */

/*
*       题解：通过递归回溯的方式完成括号的匹配，明确递归函数的功能，参数：ans存储答案，s1存储括号，open左括号的数量
*       close右括号的数量，max括号的对数，对于括号匹配我们分析需求为，若左括号数量未超过max,则可以添加一个左括号，若
*       右括号数量未超过左括号则可以添加一个右括号，递归退出条为 s1 == 2 * max。
* */

public class Code_22括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void dfs(List<String> ans,StringBuilder s1,int open, int close, int max) {
        if(s1.length() == 2 * max) {
            ans.add(s1.toString());
            return ;
        }
        if(open < max) {
            s1.append('(');
            dfs(ans,s1,open+1,close,max);
            s1.deleteCharAt(s1.length() - 1);
        }
        if(close < open) {
            s1.append(')');
            dfs(ans,s1,open,close + 1,max);
            s1.deleteCharAt(s1.length() - 1);
        }
    }
}
