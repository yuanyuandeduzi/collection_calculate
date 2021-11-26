package 模拟;

import java.util.Arrays;

/**
*       题目：给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *      输入：s = "owoztneoer"
 *      输出："012"
 *      输入：s = "fviefuro"
 *      输出："45"
* */

/*
*       题解：我们可以先对 s 进行词频统计，然后根据「英文单词中的字符唯一性」确定构建的顺序，最后再对答案进行排序。对于0~9的英文单词观察我们发现，
*       0中的z只有0有，所以z字母的个数就是0的个数，2中的w只有2有，所以w的个数就是2的个数，8中的g,6中的x,在6将s去除后，此时词频统计中的s的个数
*       就是7的个数，5中的v,在5将5中的f去除后，此时f即可表示4的个数...由此，我们可以得到一个可行的查询序列{0, 2, 8, 6, 7, 5, 4, 1, 3, 9
*       定义数组存放0~9的英文单词，此数组的角码与单词意义相关联。定义cnt数组遍历统计字母个数，遍历可行序列，开始计算个数，对于可行序列对应的英文
*       单词，用k记录其字母的最小值，此值则为此数字的个数（表示此字母只有此单词拥有，则其可以表示此数字的个数），然后将对应字母的个数减少k。最后对
*       答案排序。
* */

public class Code_423从英文中重构数字 {
    public String originalDigits(String s) {
        String[] strings = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] num = new int[]{0, 2, 8, 6, 7, 5, 4, 1, 3, 9};
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder st = new StringBuilder("");
        for (int i : num) {
            int k = Integer.MAX_VALUE;
            for (char c : strings[i].toCharArray()) {
                k = Math.min(k,cnt[c - 'a']);
            }
            for (char c : strings[i].toCharArray()) {
                cnt[c - 'a'] -= k;
            }
            while(k != 0) {
                st.append(i);
                k--;
            }
        }
        char[] chars = st.toString().toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
