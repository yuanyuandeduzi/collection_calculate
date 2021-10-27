package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 *      题目：给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：下类中的Node类，填充它的每个 next 指针，
 *      让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。初始状态下，所有 next 指针都被设置为 NULL。
 */

/*
*       题解：观察题目，他需要我们将每一层的节点通过next指针链接起来，所以我们可以采用层序遍历树的思路，我们直到通过队列来实现层序遍历时会用队列
*       将每层的节点都存储起来，然后依次将其拿出用于下层节点的扩充，此时我们将当前节点拿出，让其的next指针指向此时队列的收元素，然后重复此过程完
*       成对树节点的next指针的指向。
*
* */

public class 填充每一个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != len - 1)
                    node.next = queue.peek();
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
