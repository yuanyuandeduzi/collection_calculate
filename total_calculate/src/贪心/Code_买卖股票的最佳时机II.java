package 贪心;

/*
*       题目：给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。设计一个算法
*       来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
*       输入：prices = [7,1,5,3,6,4]  输出：7
*       输入: prices = [1,2,3,4,5]   输出：4
*       输入：prices = [7,6,4,3,1]   输出：0
*/

/*
*       题解（我的）：定义buy用于记录到当前位前的最小值点，即股票买入点，定义ans记录当前收入，遍历数组
*       每次刷新buy,保证他是当前位前最小值，判断当前位于下一位的大小关系，若当前位大于下一位且当前有买
*       入股票（即当前值大于buy）则卖出股票，刷新buy,反之则跳过，最后位最后一位处理边界问题
*
*       思考思路：判断当前求解公式是否能分割为更小子式求和
*       题解（官方贪心）：由于股票的购买没有限制，因此整个问题等价于寻找x个不相交的区间(i, ri]的最大和
*       我们注意到（j，i）这个区间的贡献值a[i] - a[j] 等价于(a[i] - a[i - 1]) + (a[i - 1] - a[i-2])
*       + (a[i-2] - a[i-3])……+ (a[j + 1] - a[j]),所以对整个数组来看，当后一位与前一位的差大于零
*       即带来收益，所以遍历数组求收益和
 * */

public class Code_买卖股票的最佳时机II {

    public int maxProfitG(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            ans +=Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int maxProfitM(int[] prices) {
        int ans = 0, buy = prices[0];
        for(int i = 1; i < prices.length - 1; i++) {
            buy = Math.min(buy, prices[i]);
            if(prices[i] > prices[i + 1] && prices[i] > buy) {
                ans+=(prices[i] - buy);
                buy = prices[i + 1];
            }
        }
        if(prices.length > 1 && prices[prices.length - 1] >= prices[prices.length - 2]) {
            if(prices[prices.length - 1] > buy) {
                ans += (prices[prices.length - 1] - buy);
            }
        }
        return ans;
    }
}
