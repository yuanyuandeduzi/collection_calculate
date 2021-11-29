package 动态规划;

/**
*       题目：在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 *      你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 *      如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *      输入:
 *      gas  = [1,2,3,4,5]
 *      cost = [3,4,5,1,2]
 *      输出：3
 */

/*
*       题解：遍历一遍数组，尝试所有位置为出发点，看从此点出发能否走完所有点，若能则返回此点，若不能，则尝试下一点，直至尝试完所有点，返回-1.
*
*       判断此出发点能否走完全程，定义cnt记录做过的点的个数，sumGas记录走到该点收获的油量，sumCost记录走到该点需要消耗的油量。由于数组存在
*       循环问题，所以下一点的更新通过取余完成，实现走到末尾后下一次走到数组头部。while循环，判断cnt是否小于len,若cnt==len，表示从此处出发
*       点能走完全程，退出循环，内部若 sumGas < sumCost，则退出循环，表示该点以无法走到下一点，退出循环，否则cnt++，判断能否走到下一点。
*
*       新的出发点的更新，定义ans记录出发点，通过cnt可以知道从上一出发点最远能走多远，新的出发点为 ans + cnt + 1, 如果x到不了y+1（但能到y），
*       那么从x到y的任一点出发都不可能到达y+1。因为从其中任一点出发的话，相当于从0开始加油，而如果从x出发到该点则不一定是从0开始加油，可能还有
*       剩余的油。既然不从0开始都到不了y+1，那么从0开始就更不可能到达y+1了.
* */

public class Code_134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int ans = 0;
        while(ans < len) {
            int cnt = 0;        //记录能走的个数
            int sumGas = 0;
            int sumCost = 0;
            while(cnt < len) {
                int j = (ans + cnt) % len;
                sumGas += gas[j];
                sumCost += cost[j];
                if(sumGas < sumCost) {
                    break;
                }
                cnt++;
            }
            if(cnt == len) {
                return ans;
            }else {
                ans = ans + cnt + 1;
            }
        }
        return -1;
    }
}
