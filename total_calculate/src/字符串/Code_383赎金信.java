package 字符串;

import java.util.HashMap;

/**
*       题目：为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *      给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *      如果可以构成，返回 true ；否则返回 false 。
 *      magazine 中的每个字符只能在 ransomNote 中使用一次。
 *      输入：ransomNote = "aa", magazine = "aab"
 *      输出：true
 * */

/*
*       题解：简单的字符串字母匹配问题，我们现统计magazine中的字母个数，此处一种是使用hashmap统计字母个数，另一种采用位桶数组统计
*       字母个数（由于只有26个字母，所以我们可用26位数组实现字母与个数的一一对应关系），统计完字母个数后，遍历ransomNote数组，将
*       其出现的字母在统计的个数中减一，若某个字母被使用完，则返回false,若遍历完数组，则返回true.
*
* */
public class Code_383赎金信 {
    public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if (map.get(ransomNote.charAt(i)) == 0) {
                return false;
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(char chars:magazine.toCharArray()) {
            cnt[chars - 'a']++;
        }
        for(char ch:ransomNote.toCharArray()) {
            if(cnt[ch-'a'] == 0) {
                return false;
            }else {
                cnt[ch - 'a']--;
            }
        }
        return true;
    }
}
