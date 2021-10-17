package 递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Code_39数组总和 {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int candidate : candidates) {
            int sum = 0;
            dfs(candidates,new ArrayList<Integer>(),candidate,sum,target);
        }
        return list;
    }
    public void dfs(int[] candidate, List<Integer> list, int n, int sum, int target) {
        list.add(n);
        sum += n;
        if (sum > target) {
            return ;
        } else if (sum == target) {
            if(this.list.size() == 0) {
                this.list.add(new ArrayList<>(list));
            }else {
                int[] arr = new int[list.size()];
                int i = 0;
                for (Integer integer : list) {
                    arr[i++] = integer;
                }
                Arrays.sort(arr);
                List<Integer> list2 = this.list.get(this.list.size() - 1);
                for (int i1 : arr) {
                    System.out.print(i1);
                }
                System.out.println(list);
                for (i = 0;i < arr.length;i++) {
                    if(i > list2.size()) {
                        break;
                    }
                    if(arr[i] != list2.get(i)) {
                        this.list.add(new ArrayList<>(list));
                    }
                }
            }
            return ;
        }
        for (int i : candidate) {
            dfs(candidate,list,i,sum,target);
            list.remove(list.size() - 1);
        }
    }

}
