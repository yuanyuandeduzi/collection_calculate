package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */

/*
 *       题解：通过递归实现二叉树的遍历，定义print方法，参数为（TreeNode,list）,二叉树头节点和用于存放输出结果的list集合，
 *       此递归方法的功能为，若当前节点不为空，则将其输出。
 *       递归退出条件为当前节点为空，若不为空则将其加入输出集合，然后按照左右顺序判断当前节点的左右节点。
 * */
public class Code_144二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
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
