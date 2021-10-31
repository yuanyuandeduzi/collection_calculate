package 树;

/**
*       题目：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *       有效 二叉搜索树定义如下：
 *       节点的左子树只包含 小于 当前节点的数。
 *       节点的右子树只包含 大于 当前节点的数。
 *       所有左子树和右子树自身必须也是二叉搜索树。
* */

/*
*       题解：定义递归方法isValidBST(TreeNode root,long min, long max)，此递归方法的功能为判断以root为根节点的树上的节点的范围是不是
*       在（min,max）,递归方法的条件条件为  若当前节点为null，表示遍历值树的最子节点，返回true,判断当前节点的值是否符合当前树的值的范围，若
*       不符合返回false,若符合则区递归判断当前节点的左右子树，若左右子树都符合条件则返回true,反之返回false。递归初始化min,max为无限小和无限
*       大，表示对于最层根节点来说，根节点一定符合条件。
* */

public class Code_98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
