package 贪心;

/*
*   给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
*   判断你是否能够到达最后一个下标。
*   输入：nums = [2,3,1,1,4]  输出：true   输入：nums = [3,2,1,0,4]  输出：false
* */

/*
*   解题思路：定义一个值用于记录当前所能走到的最大阶数，如果在此阶数之前有能走到超过此最大值的阶数则更新此最大值，如果
*   最大值超过最后一个台阶，则返回true，否则在遍历完数组后返回false
* */

public class Code_55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= max) {
                max = Math.max(max, i + nums[i]);
                if(max >= nums.length-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
