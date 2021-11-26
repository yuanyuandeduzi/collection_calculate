package 模拟;

import java.util.HashSet;
import java.util.Set;

/**
*       题目：给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
 *      交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *      例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *      输入：s = "ab", goal = "ab"
 *      输出：false
* */

/*
*       题解：若两个字符串长度不相等，直接返回false,定义n用于记录两个字符串中不同的字母的个数，n1, n2 记录两个不相同的位置，遍历字符，遇见相同位不同的字母，n++;
*       之后对n进行边界模拟，若 n == 0,此时已经可以说明两个字符串相同，此时若有某个字母出现两次以上，则交换此两相同字母，符合条件。
*       若 n == 2,此时 判断s的n1位是否与goal的n2位 并且 s的n2位是否与goal的n1位 相等，返回其判断结果，若n为其他值，则直接返回false;
*
* */

public class Code_859亲密字符串 {
    public boolean buddyStrings(String s, String goal) {
        int n = 0;
        int n1 = 0, n2 = 0;
        if(s.length() != goal.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                n++;
                if(n == 1) {
                    n1 = i;
                }else if(n == 2) {
                    n2 = i;
                }
            }
        }
        if(n == 0) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++) {
                if(!set.add(s.charAt(i))) {
                    return true;
                }
            }
            return false;
        }else if(n == 2) {
            return (s.charAt(n1) == goal.charAt(n2) && s.charAt(n2) == goal.charAt(n1));
        }
        return false;
    }
}
