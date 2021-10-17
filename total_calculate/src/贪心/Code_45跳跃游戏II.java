package 贪心;

/*
*       给你一个非负整数数组nums ，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以
*       跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。假设你总是可以到达数组的最后一个位置。
*       输入：nums = [2,3,1,1,4]  输出：2     输入：nums = [2,3,0,1,4]  输出：2
* */

/*
*      题解（自己）：设置左右指针由于标记当前一步所能走到的区间，然后从此区间中确定出下一步能走到的最远位置，若此位置大于等于最后一阶台阶，
*      返回步数，不然继续遍历数组，每当遍历位置超过上一步所能走到的最远位置时，步数加一，更新left,right的值，然后继续在左右值中间寻找下
*       一步能到达的最远距离，人然后进行边界处理
* */

public class Code_45跳跃游戏II {
    public int jumpM(int[] nums) {
        int n = 1;
        int left = 0;
        int right = 0;
        int max = nums[0];
        if(nums.length == 1) {
            return 0;
        }else if(nums[0] >= nums.length - 1) {
            return 1;
        }
        while(true) {
            left = right;
            right = max;
            for(int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
                if(max >= nums.length - 1)
                {
                    return n + 1;
                }
            }
            n++;
        }
    }
    public int jumpG(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
