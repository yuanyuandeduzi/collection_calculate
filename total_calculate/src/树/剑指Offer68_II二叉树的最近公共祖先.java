package 树;

/**
*       题目：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示
 *       为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *       输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *       输出: 3
 *       解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
* */

/*
*       题解：定义递归方法lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)，此递归方法的功能为在此二叉树中寻找p,q或者
*       p,q的最近公共父节点。递归方法的退出条件，若当前节点为null,则表示已寻找至树的结尾，但并未发现p或者q,此时返回null,若当前节点为q或p,则
*       返回将当前节点返回，若当前节点的左右子树分别包含一个p或者q，即（p,q在当前节点的异侧，left != null && right != null），则表示当前
*       节点为p,q的最近公共祖先，返回当前节点，此时两个不为空的分支合并为了一支。若当前节点的左右子树只有一个含有p,q节点，返回那个不为空的子树的
*       节点，若都为空，则返回null。
* */

public class 剑指Offer68_II二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {        //通过此判断将节点更新
            return root;
        }
        return left == null ? right : left;     //两者都为空null返回null。
    }
}
