package 递归;

import java.util.ArrayList;
import java.util.List;

public class Code_40数组总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates,list,ans,target,0);
        return ans;
    }

    public void dfs(int[] candidate,List<Integer> list, List<List<Integer>> ans,int target, int idx) {
        if(idx == candidate.length) {
            return ;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        dfs(candidate,list,ans,target,idx+1);
        if(target - candidate[idx] >= 0) {
            list.add(candidate[idx]);
            dfs(candidate,list,ans,target - candidate[idx],idx+1);
            list.remove(list.size() - 1);
        }
    }
}
