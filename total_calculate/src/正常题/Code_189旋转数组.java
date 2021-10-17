package 正常题;

import java.util.ArrayList;
import java.util.List;

/*
*       题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*
*       输入： nums = [1,2,3,4,5,6,7], k = 3
*       输出: [5,6,7,1,2,3,4]
*       输入：nums = [-1,-100,3,99], k = 2
*       输出：[3,99,-1,-100]
* */

/*
*       题解：将数组向右偏移k位，相当与将后k位拿出来放在数组的0号位前面组成一个新的数组，所以我们可以通过多次翻转数组实现
*       ，第一次反转所有数组可以将后面的数组元素转移至数组前面，下面我们为您只需再进行两次翻转数组将带哦换至前面的元素顺序
*       更正即可，第一次翻转前k位，即将后k位转移至前面，再翻转k位至数组结束，表示牵绊部分数组数组的平移
* */

public class Code_189旋转数组 {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reserve(nums,0,len - 1);
        reserve(nums,0,k - 1);
        reserve(nums,k,len - 1);

    }

    public void reserve(int[] nums, int start, int end) {
        while(start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start += 1;
            end -= 1;
        }
    }

    public void rotateM(int[] nums, int k) {
        int len = nums.length;
        k = len - k % len;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(i < k) {
                list1.add(nums[i]);
            }else {
                list2.add(nums[i]);
            }
        }
        for(int i = 0 ; i < list2.size(); i++) {
            nums[i] = list2.get(i);
        }
        for(int i = 0, j = list2.size(); i < list1.size(); i++, j++) {
            nums[j] = list1.get(i);
        }
    }
}
