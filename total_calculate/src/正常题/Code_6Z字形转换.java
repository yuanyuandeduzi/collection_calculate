package 正常题;

import java.util.ArrayList;
import java.util.List;

/*
 *       题目：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *       比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *           P   A   H   N
 *           A P L S I I G
 *           Y   I   R
 *       之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *       请你实现这个将字符串进行指定行数变换的函数：
 *
 *       输入：s = "PAYPALISHIRING", numRows = 3
 *       输出："PAHNAPLSIIGYIR"
 *
 *       输入：s = "PAYPALISHIRING", numRows = 4
 *       输出："PINALSIGYAHRPI"
 *       解释：
 *       P     I    N
 *       A   L S  I G
 *       Y A   H R
 *       P     I
 * */

/*
 *       题解：按行排序，定义list集合用于将每行的元素先进性存储，在存储完所有元素后在将list集合中的元素按行拿出
 *       ，拼接程题目所示的字符串，list集合中的元素类型为StringBuilder类型，用于字符串的累加，个数为 输入的行数
 *       与字符串长度中小的那个，然后按字符串顺序以此按照 从上至下，后从下至上的栓徐以此将其添加至对应的行后面，定义
 *       int n = 0,用于记录当前添加至那一行，定义boolean goDown = false:（用于判断是向上走还是向下走），初始
 *       定义为向下，因为n = 0,会触发边界的方向更换，边界的方向更换条件为 n == 0 || n == numRows - 1,n 的增加
 *       逻辑由goDown决定，向下则每次加一，向上则每次减1 ，最终将list集合中存储的字符串拿出，拼接返回
 * */

public class Code_6Z字形转换 {

    public String convertG(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }
        int n = 0;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            list.get(n).append(c);
            if (n == 0 || n == numRows - 1) goDown = !goDown;
            n += goDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder s1 : list) {
            ans.append(s1);
        }
        return ans.toString();
    }

    public String convertG2(String s, int numRows) {        //通过寻找每次叠加元素的位置，没为此将本行的算有元素直接找出添加，跳着遍历完字符串

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
