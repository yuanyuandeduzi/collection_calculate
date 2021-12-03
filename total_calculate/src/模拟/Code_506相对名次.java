package 模拟;

import java.util.Arrays;
import java.util.HashMap;

/**
*       题目：给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *      运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *          名次第 1 的运动员获金牌 "Gold Medal" 。
 *          名次第 2 的运动员获银牌 "Silver Medal" 。
 *          名次第 3 的运动员获铜牌 "Bronze Medal" 。
 *          从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 *          使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
* */

/*
*       题解：哈希表+排序，先将原数组拷贝进一个新数组，然后对其进行排序，定义HashMap集合存储成绩和位次，key为成绩，values为位次。
*       将排序后的数组遍历，并将其存入map集合，排序后的角码与其排名有关，或按顺序依次设置名词，然后遍历元素组，用原数组成绩顺序在map
*       中查找排名，将其添加至ans，最后返回ans.
*
* */

public class Code_506相对名次 {
    private String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        int[] clone = score.clone();
        String[] ans = new String[len];
        Arrays.sort(clone);
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = 1;
        for(int i = len - 1; i >= 0; i--) {
            map.put(clone[i],n++);
        }
        for(int i = 0; i < len; i++) {
            n = map.get(score[i]);
            if(n <= 3) {
                ans[i] = ss[n - 1];
            }else {
                ans[i] = String.valueOf(n);
            }
        }
        return ans;
    }
}
