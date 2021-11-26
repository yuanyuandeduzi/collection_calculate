package 链表;

public class Code_21合并两个升序链表 {
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
