package 树;

import java.util.HashMap;

/**
*       题目：给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *      Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 *      Output: [3,9,20,null,null,15,7]
* */

/*
*       题解：解题思路与从中序和后序遍历构造二叉树一样，只是将通过后序从后至头获得根节点换为前序遍历的从头至尾获得根节点，还有就是通过中序
*       获得左右子树的长度后对于前序遍历的划分有所区别，通过中序获得的左子树长度为 ri - is, 对于前序遍历有ps为当前节点，所以左子树起点为
*       ps + 1,所以左子树的范围为 （ps + 1， ps + ri - si),同理右子树范围为 （ps + ri - si + 1，pe)
* */

public class Code_105从前序与中序遍历构造二叉树 {

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = 0;
        for (int i : inorder) {
            map.put(i, n++);
        }
        return getTree(0, inorder.length - 1, 0, preorder.length - 1, preorder);
    }

    public TreeNode getTree(int is, int ie, int ps, int pe, int[] preorder) {
        if (is > ie || ps > pe) {
            return null;
        }
        int ri = map.get(preorder[ps]);
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = getTree(is, ri - 1, ps + 1, ps + ri - is, preorder);
        root.right = getTree(ri + 1, ie, ps + ri - is + 1, pe, preorder);
        return root;
    }
}
