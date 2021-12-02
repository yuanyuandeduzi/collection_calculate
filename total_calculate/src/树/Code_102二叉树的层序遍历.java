package 树;

import java.util.*;

/**
*       题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
*       示例：
*       二叉树：[3,9,20,null,null,15,7],
*       返回其层序遍历结果：
*       [
*       [3],
*       [9,20],
*       [15,7]
*       ]
* */

/*
*       题解：通过广度优先搜索思路完成二叉树的层序遍历，定义queue用于存放每层的节点，并用于下一层节点的扩充，queue中每此只会存储一层的节点，
*       在进行下一层节点的扩充时会将上一层系欸点那全部出队，此逻辑通过for循环实现，定义len = queue.size()，即len为磁层的节点数，每次将当
*       前节点的数值加入一个list集合（用于存放当前层的数），然后判断其左右节点是否为空，不为空则将其入队，完成队列的扩充，最终将list集合加入
*       ans集合，完成广搜，返回ans集合
* */

public class Code_102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
