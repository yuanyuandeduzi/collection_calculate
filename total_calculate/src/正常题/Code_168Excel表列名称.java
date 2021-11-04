package 正常题;

/**
*       题目：给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *      例如：
 *          A -> 1
 *          B -> 2
 *          C -> 3
 *          ...
 *          Z -> 26
 *          AA -> 27
 *          AB -> 28
 *          ..。
 *          输入：columnNumber = 1
 *          输出："A"
 *
 *          输入：columnNumber = 701
 *          输出："ZY"
 * */

/*
*           题解：这是一道从 11 开始的的 2626 进制转换题。对于一般性的进制转换题目，只需要不断地对 columnNumber 进行 % 运算取得最后一位，
*           然后对 columnNumber 进行 / 运算，将已经取得的位数去掉，直到 columnNumber 为 0 即可。但此题并不是从0开始的，一般我们的进制
*           转换的题的范围都是再[0,X]的前提下进行的逢x进一，所以无需进行任何处理，但此题的范围为[1,26],因此我们再执行进制转换前需要对columnNumber
*           执行一次自减，让其取余得到的值整体偏移一位，此时假如是 26，我们让其自减1 ，成为25，刚好为进位的最后一位，对应‘A’ + 25,即刚好是Z,
*           若不进行自减，26取余为0,则不符合要求。
* */

public class Code_168Excel表列名称 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;     //重要的一步
            stringBuilder.append((char)((columnNumber % 26) + 'A'));
            columnNumber = columnNumber/ 26;
        }
        return stringBuilder.reverse().toString();
    }
}
