package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 *      题目：给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *      请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *      输入：nums = [100,4,200,1,3,2]
 *      输出：4
 *      输入：nums = [0,3,7,2,5,8,4,6,0,1]
 *      输出：9
 * */

/*
*       题解：由于想要尽量的快，所以不用排序实现。我们知道set集合的查询可以达到O(1),所以我们定义Set集合hashSet,将数组中的元素全部存入set集合
*       中，然后遍历数组，判断当前点i是否为某一连续序列的起点，判断set集合中是否存在当前值num[i] - 1的点，若存在，则表示当前点不为起始点，则跳过
*       当前点。若为连续序列的起点，则判断set集合中是否存在num[i] + 1，若存在，则向前推进，此过程记录序列长度，最后更新ans。返回最大值。
* */

public class Code_128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentCnt = 1;
                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentCnt++;
                }
                ans = Math.max(ans, currentCnt);
            }
        }
        return ans;
    }
}
