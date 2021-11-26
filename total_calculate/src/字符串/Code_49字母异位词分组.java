package 字符串;

import java.util.*;

/**
*       题目：给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *      字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *      输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *      输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
* */

/*
*       题解：对于两个字母相同的不同字符串，我们对其进行字母排序后的，排序后的两个字符串是相同的，所以
*       我们可以通过对排序后的字符串的比对实现找到到字母异位词，我们通过HashMap去存储找到的字母异位词
*       ，用map的key去存储排序后的字符串，value存储存放字母异位词的list集合。最终将map转换为list集合返回。
* */

public class Code_49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
