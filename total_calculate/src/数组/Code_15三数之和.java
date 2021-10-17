package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*       题目：给你一个包含 n 个整数的数组nums，判断nums中
*       是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为
*       0 且不重复的三元组。
*       注意：答案中不可以包含重复的三元组
* */
/*
*       解题思路：先将数组按升序排序，题目要求找出三个元素，所以我们先自己固定一个值n，然后用双指针指向
*       n后数组的两端（由两边向中间遍历求和，容易控制求值，当sum大于0，右指针左移，当sum小于0，左指针右移）
*       求取sum为零的三个值，将其加入list集合，需要每次创建一个新的集合对象
*       去重：
*       如果 nums[i]nums[i]大于 0，则三数之和必然无法等于 0，结束循环
*       如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过 (下一固定点不能和上一固定点一样)
*       当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++；
*       当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--；
*      （当固定值不变时，当且仅当其他两值为nums[L],nums[R]时和为0，所以需要将与此次左右相等的数值跳过，）
*       去重完成后将左右指针中移
*  */

public class Code_15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int left, right, sum;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return list;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> mList = new ArrayList<>();
                    mList.add(nums[i]);
                    mList.add(nums[left]);
                    mList.add(nums[right]);
                    while(left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while( left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                    list.add(mList);
                }else if(sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return list;
    }
}
