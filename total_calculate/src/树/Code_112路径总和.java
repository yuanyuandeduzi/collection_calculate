package 树;

/**
*       题目：给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在
 *       根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。叶子节点 是指没有子节点的节点。
* */

/*
*       题解：定义递归方法hasPathSum(TreeNode root, int targetSum),递归方法的功能为判断当前节点的值是否与当前的targetSum是否相等，且
*       当前节点为二叉树的最子页节点则返回true,若搜索完此路仍未相等，即当前节点为null，则返回null,若不为上两种情况，则便是在树中间，则向下递归
*       判断当前节点的左右子树，targetSum更新为减去上面节点val的值，即将上一节点除去后仍需的数值大小
* */

public class Code_112路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {   //当递归至最子页时，判断当前所剩的targetSum是否与当前节点的值相等
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
