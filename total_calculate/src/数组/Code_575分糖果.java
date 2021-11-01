package 数组;

import java.util.Arrays;

/**
*       题目：给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给
 *       一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
* */

/*
*       题解：由于需要平分，所以妹妹能拿的个数为糖果树的一半ans，为了保证妹妹拿到更多种类的糖果数，我们只需将尽可能多的种类的
*       糖果分给妹妹即可，所以我们对数组进行排序，然后统计数组中元素不同的个数，将统计出来的个数n与ans比较，若n大于ans,则妹妹
*       能拿到的最大种类数为ans（即妹妹所拿的每个的糖种类都不一样），反之，则为n(即妹妹将每种糖都拿了一个)。
* */

public class Code_575分糖果 {
    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        int ans = len / 2;
        int n = 1;
        Arrays.sort(candyType);
        for (int i = 0; i < len - 1; i++) {
            if(candyType[i] != candyType[i + 1]) {
                n++;
            }
        }
        return Math.min(ans,n);
    }
}
