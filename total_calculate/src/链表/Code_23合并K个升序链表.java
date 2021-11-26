package 链表;

/**
*       题目：给你一个链表数组，每个链表都已经按升序排列。
 *      请你将所有链表合并到一个升序链表中，返回合并后的链表。
* */

/*
*       题解：合并k个升序序列，我们可以将问题转化为多次的合并两个升序序列，定义ans用于记录已合并的肾虚序列，
*       然后让ans分别与剩余的升序链表一一合并，最终合并完成，返回ans。
*
* */

public class Code_23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode ans = lists[0];
        for(int i = 1; i < lists.length; i++) {
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode lastNode = newHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            }else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        lastNode.next = l1 == null?l2:l1;
        return newHead.next;
    }
}
