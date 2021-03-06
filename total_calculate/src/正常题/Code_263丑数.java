package 正常题;

/*
*       题目：给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
*       丑数 就是只包含质因数2、3 , 5的正整数。
*
*       输入：n = 6        输入：n = 8
*       输出：true         输出：true
*       解释：6 = 2 × 3        解释：8 = 2 × 2 × 2
*  */

/*
*       题解：丑数表示可以分解为只由2，3，5相乘得到的值，所以依次一直循环除以2， 3， 5，若除后的值仍能被
*       当前值整除，则继续除，否则则跳至下一值由开始循环除，整除判断为取余为0，最后判断剩余值是否为1,若为
*       1，则为丑数，边界处理0，小于0的值不为丑数
* */


public class Code_263丑数 {
    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }
        int[] arr = {2,3,5};
        for(int m : arr) {
            while(n % m == 0) {
                n /= m;
            }
        }
        return n == 1;
    }
}
