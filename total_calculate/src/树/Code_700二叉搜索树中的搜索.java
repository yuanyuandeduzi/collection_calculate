package 树;

/**
*       题目：给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *       给定二叉搜索树:
 *         4               输出：2
 *        / \                  / \
 *       2   7                1  3
 *      / \
 *     1   3
 *     和值: 2
* */

/*
*       题解：定义递归方法searchBST（TreeNode root, int val），在当前中搜索根节点为目标值的子树，
*       递归方法的退出条件为：若当前节点为null，则返回null.
*                         若当前节点的值等于目标值，则返回当前节点。
*       若当前节点不为null,且值不为目标值，则去搜索其左右子树，返回其左右子树不为空的节点。
*
*       优化：由于题给二叉树为二叉搜索树，所以对于当前节点来说，其左子树的所有节点均小于当前节点的值，其右
*       子树的所有节点值大于当前节点的值，所以我们可以通过当前节点的值与目标节点的值进行比较，若比目标值小，
*       则去搜索其右子树，反之搜做左子树，从而减少一边的递归搜索。
* */

public class Code_700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right,val);
        return left == null && right == null ? null:(left == null? right:left);
    }
    public TreeNode searchBSTTwo(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }
        return root.val < val ? searchBSTTwo(root.right,val) : searchBSTTwo(root.left,val);
    }
}
