package 数学;

/**
*       题目：有 buckets 桶液体，其中 正好 有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，
 *       通过观察猪是否会死进行判断。不幸的是，你只有 minutesToTest 分钟时间来确定哪桶液体是有毒的。喂猪的规则如下：
 *
 *      选择若干活猪进行喂养
 *      可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
 *      小猪喝完水后，必须有 minutesToDie 分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
 *      过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
 *      重复这一过程，直到时间用完。
 *      给你桶的数目 buckets ，minutesToDie 和 minutesToTest ，返回在规定时间内判断哪个桶有毒所需的 最小 猪数。
* */


/*
*       题解：我们让最小需要的猪的数量为 x,经过的轮数为 n(minutesToTest / minutesToDie),题目转换为x只猪在n轮可以检测多少通水。
*       当n = 1，x = 2时，此时最多可以检测4桶水，让 猪1 喝 1，2桶水，让猪2 喝 2，3桶水，如果 猪1 死，猪2 活，那么，1号桶有毒
*       如果 猪1 死，猪2 死，那么，2号桶有毒；如果 猪1 活，猪2 死，那么，3号桶有毒；如果 猪1 活，猪2 活，那么，4号桶有毒；
*       当 n = 1，x = 3时，此时最多可以检测8桶水。
*       分析：对此我们发现，经过一轮，对于每只猪，要么死要么活，一共只有两种状态，那么对于x只猪来说，经过一轮，就存在2^x种状态，所以可
*       以检测2^x桶水（每种状态对应一种标号水有毒的状态）。
*       那么对于一只猪在经过n轮时，要么在第一轮死，要么在第二轮死……要么第n轮死，要么不死，一共有（n + 1）种状态，那么对于x只猪来说，就
*       有（n + 1）^ x种状态，对应表示x只猪在经过n轮时所能检测的水的个数。而x即为我们需要求得量。
*       有（n + 1）^ x = buckets -> x = log(n + 1) (buckets) = log (e) (buckets) / log (e) (n + 1);
*       由于最终为最小值，所以对结果向上取整。
* */

public class Code_458可怜的小猪 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie;
        return (int)Math.ceil(Math.log(buckets) / Math.log(n + 1));
    }
}
