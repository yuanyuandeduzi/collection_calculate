package 树;

/**
*       输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *      例如：给定二叉树 [3,9,20,null,null,15,7]，
 *      输出：3
* */

/*
*       题解：通过递归实现树的深度计算，定义getDepth(root，depth)递归方法，此递归方法的功能为尽可能的向树的深层进行搜索，每层中的depth参数会
*       记录当前层的深度，若当前节点为空则返回，若当前节点的为书的最最子叶节点（即此节点的左右节点都为空），此时进行ans的更新，ans为一全局变量，用
*       于记录树的最大深度，最终返回ans
* */

public class 剑指Offer55_1二叉树的深度 {
    private int ans = 0;

    public int maxDepthJ(TreeNode root) {       //尽可能深的搜索树，在回溯时完成深度值的统计
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }
        ans = 1;
        getDepth(root, 1);
        return ans;
    }

    public void getDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans = Math.max(depth, ans);
        }
        getDepth(root.left, depth + 1);
        getDepth(root.right, depth + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
