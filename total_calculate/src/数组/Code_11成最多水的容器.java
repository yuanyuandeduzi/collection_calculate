package 数组;

/*
*       题目：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两
*       个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
*       说明： 你不能倾斜容器
*
*       输入：[1,8,6,2,5,4,8,3,7]
*       输出：49       解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳的的最大值为 49。
*
*       输入：height = [1,1]
*       输出：1
*  */

/*
*       解题思路：本题采用双指针思路，容器所能容纳的最大值求法为：左右两边中较低一边乘以左右两边的差值（底长），所以我们
*       用左右两个指针去表示容器左右边的位置，它的height可通过边的位置得到，由于需要维护底的一个最大值，所以我们让left
*       = 0, right = height.length - 1，此时底为最大值，然后向中靠近，每次移动左右指针中小的那个（保证下次的容量
*       可能超过当前值），定义ans记录在（left < right）过程中的最大值。
*
* */


public class Code_11成最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while(left < right) {
            ans = Math.max(Math.min(height[right],height[left]) * (right - left) , ans);
            if(height[right] < height[left]) {
                right--;
            }else {
                left++;
            }
        }
        return ans;
    }
}
