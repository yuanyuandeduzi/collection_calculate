package 递归;

import java.util.ArrayList;
import java.util.List;

/*
*       题目：给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
*       candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。对于给定的输入，保证和为target 的唯一
*       组合数少于 150 个。
*       输入： candidates = [2,3,6,7], target = 7
*       输出: [[7],[2,2,3]]
*
*       输入: candidates = [2,3,5], target = 8
*       输出: [[2,2,2,2],[2,3,3],[3,5]]
* */

/*
*       题解G：对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
*       通过定义递归函数dfs(target,list,dix)表示在dix位还剩target要组合，以组合的列表为list,递归退出条件为 dix == candidates.length,
*       即最后一位的数组元素也考虑了是否加入，或target == 0,即当前值符合条件，将其加入ans集合。对于当前位有两种方式，跳过当前位，即执行
*       dfs(target, list, idx + 1),将当前位加入，即执行dfs(target - candidates[idx], list, idx).由于元素可以重复使用，所以将当
*       前位加入后下一位仍可以选择将当前位加入或不加入，然后再将用于返回答案的ans和输入的数组加入dfs参数位。
* */

public class Code_39数组总和G {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, combine, ans, target, 0);
        return ans;
    }

    public void dfs(int[] candidate, List<Integer> list, List<List<Integer>> ans, int target, int dix) {
        if (dix == candidate.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(candidate, list, ans, target, dix + 1);     //跳过当前位

        if (target - candidate[dix] >= 0) {
            list.add(candidate[dix]);
            dfs(candidate, list, ans, target - candidate[dix], dix);    //添加当前位
            list.remove(list.size() - 1);       //回溯，递归一般必备条件
        }
    }
}
