package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
*       题目：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *       请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
* */

/*
*       题解：通过排序合并，将二维数组intervals按照每一一维数组的首元素升序排序，排序后前一一维数组能否与后一一维
*       数组合并的判断条件为前一一维数组的尾大于后裔一维数组的头，此时表示这两区间可以合并，用一list集合来记录合并
*       后的数组，循环遍历排序后的数组，更新list,当两区间断开时，将此区间添加进list，否则，则用此区间的右与list
*       最后一个元素的右去比较，用大的值作为新的最后于一个区间的右，最后将list转换数组返回。
* */

public class Code_56合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> arr = new ArrayList<>();
        arr.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(arr.get(arr.size() - 1)[1] < L) {
                arr.add(new int[] {L,R});
            }else{
                arr.get(arr.size() - 1)[1] = Math.max(arr.get(arr.size() - 1)[1],R);
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
}
