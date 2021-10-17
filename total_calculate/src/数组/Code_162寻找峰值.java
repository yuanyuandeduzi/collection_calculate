package 数组;

/*
*       峰值元素是指其值大于左右相邻值的元素。给你一个输入数组nums，找到峰值元素并返回其索引。
*       数组可能包含多个峰值，在这种情况下，返回任何一个峰值 所在位置即可。你可以假设nums[-1] = nums[n] = -∞
*       输入：nums = [1,2,3,1] 输出：2  输入：nums = [1,2,1,3,5,6,4]  输出：1 或 5
* */
/*
*       解题思路：遍历数组对当前值进行判断，判断其知否大于其左右两值，若大于，则返回其索引，若当前处于0号索引，则当其大于
*       下一位置时就返回此索引，当遍历玩数组未返回值，则返回数组最后一位索引
* */

public class Code_162寻找峰值 {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(i == 0 || nums[i] > nums[i-1]) {
                    return i;
                }
            }
        }
        return nums.length-1;
    }
}
