package 树;

import java.util.ArrayList;
import java.util.List;

/**
 *      题目：给定一个二叉树，返回它的 后序 遍历。
 *      输入：[1,null,2,3]
 *      输出: [3,2,1]
* */

/*
*       题解：与前序遍历一样，只是先进性左节点的遍历，在进行右节点的遍历，再进行当前节点的输出，在节点为null时，return,再回溯时完成指的输出，
* */
public class Code_145二叉树的后续遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        print(root, list);
        return list;
    }

    public void print(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        print(root.left, list);
        print(root.right, list);
    }

    class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
