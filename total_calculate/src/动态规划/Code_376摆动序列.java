package 动态规划;

/*
*       题目：如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
*
*           例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
*           相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
*       子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
*       给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
* */

/*
*       题解：定义up数组用于记录最后一位为上升趋势（即最后一位数值小于倒数第二位数值）的最长序列的长度，定义down用于记录最后一位为下降趋势的最长序列的长度，初始化动规数组：
*       up[0] = down[0] = 1; 对第 i 位状态转换方程为：若nums[i] > nums[i - 1], 表示下一位的摆动数（最后两位的差值）为一负值，即下一趋势位下降趋势
*       所以此时有：down[i] = Math.max(down[i - 1], up[i - 1] + 1);  下降趋势的长度一定可以从最长的上升趋势的长度加一得到，但得到的此长度需和当前的下降趋势长度比较取大值
*                 up[i] = up[i - 1];        由于此位产生下降趋势，是一上升趋势的长度可通过将当前位取出得到，即等于前一位的值
*       若nums[i] < nums[i - 1], 表示下一位的摆动数（最后两位的差值）为一正值，即下一趋势位上升趋势
*       所以此时有：up[i] = Math.max(down[i-1] + 1, up[i - 1]);
*                down[i] = down[i - 1];
*       若nums[i] == nums[i - 1]，不难想出此位必得去除，
*       那么此时有：up[i] = up[i - 1];
*                down[i] = down[i - 1];
*       遍历完数组更新两数组，最终返回  Math.max(up[len - 1], down[len - 1])
*
*       题解优化：我们发现当前位得维护只需要两中状态，一种为最后上升的，一种为最后下降的，所以我们只需定义两个值，int up = down = 1.
*       若nums[i] < nums[i - 1]，则 up = down + 1; 更新上升的最大值，由最长下降值得到，
*       若nums[i] > nums[i - 1]，则 down = up + 1; 更新下降的最大值，由最长上升值得到，
*       通过这两个值维护上升与下降得递增逻辑，最终返回  Math.max(up, down)
* */

public class Code_376摆动序列 {
    public int wiggleMaxLengthY(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return 1;
        }
        int up = 1;
        int down = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]) {
                down = up + 1;
            }else if(nums[i] < nums[i - 1]) {
                up = down + 1;
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLengthP(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return 0;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            }else if(nums[i] < nums[i - 1]) {
                up[i] = Math.max(down[i-1] + 1, up[i - 1]);
                down[i] = down[i - 1];
            }else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}
