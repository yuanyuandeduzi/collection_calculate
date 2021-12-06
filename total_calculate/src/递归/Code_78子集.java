package 递归;

import java.util.ArrayList;
import java.util.List;

/**
*       题目：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *      解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *      输入：nums = [1,2,3]
 *      输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */

/*
*       题解：通过递归实现寻找子集，定义dfs(int cnt , int[] nums),递归功能为是否将nums的第cnt位加入子集，对于
*       nums数组每个元素都存在两种状态，加入子集和不加入子集，通过递归枚举所有可能。定义中间集合list,存储子集的中间
*       状态，递归退出条件为遍历完nums数组，即cnt == nums.length。此时将list加入ans集合。
*
* */
public class Code_78子集 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }

    private void dfs(int cnt , int[] nums) {
        if(cnt == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        list.add(nums[cnt]);
        dfs(cnt+1,nums);
        list.remove(cnt);
        dfs(cnt+1,nums);
    }
}
