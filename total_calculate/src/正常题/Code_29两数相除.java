package 正常题;

/**
*       题目：给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *       返回被除数dividend除以除数divisor得到的商。
 *      整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
* */

/*
*       题解：先进性边界处理，若除数为1，则直接返回被除数，若除数为 -1，则判断被除数是否为int的最小值，若为则返回int
*       范围的最大值，否则则返回 被除数 * -1，然后由于不能使用除法，所以我们用减法代替除法，定义res记录被除数对除数
*       减的次数，首先定义flag记录两数结果的正负，将运算的数的范围升至long，并将两数转至正数进行运算，然后通过递减
*       统计运算次数 res++，最终返回res * flag。
* */

public class Code_29两数相除 {

    public int divide(int dividend, int divisor) {
        if(divisor == 1)
            return dividend;
        if(divisor == -1)
            return dividend == -2147483648? 2147483647 : dividend*-1;
        long res = 0, a = dividend, b = divisor, flag = -1;
        if((a < 0 && b < 0) || (a > 0 && b > 0)) {
            flag = 1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            a -= b;
            res++;
        }
        return (int) (res * flag);
    }

    public int divideMC(int dividend, int divisor) {
        int flag = 1;
        if (dividend > 0 && divisor > 0) {
            dividend *= -1;
            divisor *= -1;
            flag = 1;
        } else if (dividend > 0 || divisor > 0) {
            if (dividend > 0) {
                dividend *= -1;
            } else {
                divisor *= -1;
            }
            flag = -1;
        }
        int ans = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            ans--;
        }
        if(flag == -1) {
            return ans;
        }else if(ans == -2147483648){
            return 2147483647;
        }else {
            return ans * -1;
        }
    }
}
