package 动态规划;

/*
*       题目描述：给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。一个数组的子数组是
*       由原数组中零个或者更多个连续数字组成的数组。请你返回乘积为正数的最长子数组长度。
*       输入：nums = [1,-2,-3,4] 输出：4      输入:nums = [0,1,-2,-3,-4]  输出：3
*       输入：num = [5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2]
*       输出：8
* */
/*
*       题解：由于当前位置的乘积最长子串只与前一位的长度有关，所以只需用两个数来记录当前位的最长串即可，
*       定义ans实时更新记录最长串，初始化值，定义numF记录当前负数最长串，定义numZ记录当前正书最长串，
*       情况分析：若当前位大于零，则numZ加一，判断numF是否大于0，若大于则表示为负数，则也加一，反之不加
*               若当前位小于零，则numF = numZ+1,若numF>0,则numZ = numF + 1,否则numZ = 0;(此处
*       需要定义中间变量)
*               若当前位等于零，则numZ,numF都归为零，表示乘积位零
*       遍历数组进行如上逻辑操作，每次更新ans值，最终返回ans
* */

public class Code_1567乘积为正数的最长子数组长度 {
    public int getMaxLen(int[] nums) {
        int numF = nums[0] < 0? 1 : 0;
        int numZ = nums[0] > 0? 1 : 0;
        int ans = numZ;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                numZ++;
                if (numF != 0) {
                    numF++;
                }
            } else if (nums[i] < 0) {
                int numF1 = numZ + 1;
                numZ = numF > 0?numF+1:0;
                numF = numF1;
            }else {
                numF = 0;
                numZ = 0;
            }
            ans = Math.max(ans, numZ);
        }
        return ans;
    }
}
