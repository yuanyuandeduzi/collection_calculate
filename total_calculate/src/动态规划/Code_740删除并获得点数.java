package 动态规划;
import java.util.*;

/*
*   给你一个整数数组nums，你可以对它进行一些操作。每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除所有
*   等于nums[i] - 1 和 nums[i] + 1的元素。开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
*   输入：nums = [3,4,2]， 输出：6     输入：nums = [2,2,3,3,3,4]， 输出：9
* */

/*
*   解题思路：动规过程与打家劫舍相似，只需在其基础上增添一个判断。开始前对数据的处理，通过HashMap对数组中的数字的个数进行统计，键存储数值，
*   值存储该数值再数组中出现的个数，将键拿出形成set集合，将其转换为list集合，然后对其进行排序，至此完成数据的初始划。
*   定义dp数组用于记录当前位置所能删除的最大值，初始划dp数组，dp[0] = list.get(0) * 它出现的次数（通过map.get(list.get(0))获得），
*   dp[1]分两种情况，当list.get(1) != list.get(0) + 1.即不等于前移元素加一时，dp[1] = list.get(1) * map.get(list.get(1) + dp[0];
*   若等于，则dp[1] = Math.max(list.get(1) * map.get(list.get(1)), dp[0]);
*   边界判断：当只存在一种元素时，直接返回其值乘个数
*   状态转换方程: 当list.get(1) != list.get(0) + 1时，dp[i] = dp[i-1] + list.get(i) * map.get(list.get(i));
*               当list.get(1) == list.get(0) + 1时，dp[i] = Math.max(dp[i-1], dp[i-2] + list.get(i) * map.get(list.get(i)));
* */
public class Code_740删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[] dp = new int[list.size()];
        dp[0] = list.get(0) * map.get(list.get(0));
        if(list.get(1) != (list.get(0) + 1)) {
            dp[1] = list.get(1) * map.get(list.get(1)) + dp[0];
        }else {
            dp[1] = Math.max(list.get(1) * map.get(list.get(1)), dp[0]);
        }
        for(int i = 2; i < list.size(); i++) {
            if(list.get(i) != (list.get(i-1) + 1)) {
                dp[i] = dp[i-1] + list.get(i) * map.get(list.get(i));
            }else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + list.get(i) * map.get(list.get(i)));
            }
        }
        return dp[list.size()-1];
    }
}
