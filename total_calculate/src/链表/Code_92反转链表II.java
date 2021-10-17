package 链表;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


/*
*       题目：给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right。
*       请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
*       输入：head = [1,2,3,4,5], left = 2, right = 4
*       输出：[1,4,3,2,5]
*       输入：head = [5], left = 1, right = 1
*       输出：[5]
* */

/*
*       题解：编写链表反转方法用于链表的反转，在主方法中将链表进行分割，将需要反转的部分分割出来，
*       然后调用反转函数将其反转，然后将反转后的链表在进行连接，反转链表方法通过递归实现
* */

public class Code_92反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }
        ListNode listNode_head = new ListNode();        //创建头节点，便于后续操作
        listNode_head.next = head;
        ListNode p = listNode_head;     //记录第一个分割点
        while (left != 1) {
            p = p.next;
            left--;
        }
        ListNode q = listNode_head;     //记录第二个分割点
        while (right != 0) {        //此分割点需要静此点防区反转序列，所以需要必前移分割点多走一步
            q = q.next;
            right--;
        }
        ListNode head_1 = p.next;       //记录分割后的个端的头
        p.next = null;
        ListNode tail = q.next;
        q.next = null;

        p.next = res(head_1);       //反转链表，将链表重新连接
        head_1.next = tail;
        return listNode_head.next;
    }

    public static ListNode res(ListNode head) {     //递归反转链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = res(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
