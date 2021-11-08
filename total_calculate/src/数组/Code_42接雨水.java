package 数组;

/**
*       题目：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *      输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *      输出：6
 *      解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * */

/*
*       题解：维护两个指针left和right，以及两个变量leftMax和rightMax,初始时 left=0,right=n-1,leftMax=0,rightMax=0，
 *       left 只会向右移动，指针right 只会向左移动，在移动指针的过程中维护两个变量 leftMax 和 rightMax 的值。leftMax和rightMax
 *       用于记录左右边界的高度，左右指针用于向中遍历所有数组位并更新左右边界的高度，对于每一位有，若当前位小于左右边界中的小的，则其可
 *       接的雨水位小的边界减当前位的高度。
 *       当两个指针没有相遇时，进行如下操作：
 *       使用height[left] 和 height[right] 的值更新，leftMax 和 rightMax的值；
 *       如果height[left] < height[right]则必有 leftMax < rightMax，下标 left处能接的雨水量等于 leftMax - height[left]，
 *       将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位);
*        如果height[left] > height[right]则必有 leftMax > rightMax，下标 right处能接的雨水量等于 rightMax - height[right]，
 *       将下标 right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位);
* */

public class Code_42接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax > rightMax) {
                ans += (rightMax - height[right]);
                right--;
            }else {
                ans += (leftMax - height[left]);
                left++;
            }
        }
        return ans;
    }
}
