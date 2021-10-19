package 树;

/**
 *      题目：给定一个二叉树，检查它是否是镜像对称的。
 *      例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
* */

/*
*       题解：对于一棵树，我们可以将其拆分为更多的子树，对于两颗树，若两颗树都为空，则他们两个必为镜像树，若一颗为空，另一课不为空，则不为对称树，
*       若两颗树都不为空，则首先进行两棵树的根节点的数值判断，若不想等则不为对称树，若相等，则将此两个树再次进行分割，使其产生四棵树，此四棵树按照
*       两外，两内匹配，再次进行如上操作，此过程可以看作一颗大的对称树必是由两棵小的对称树组成的，而小的对称树是由更小的对称树构成的，所以我们通过
*       递归完成此逻辑，定义递归方法isTree(TreeNode p, TreeNode q),递归方法的功能为判断传入的两颗树是否为对称树。
* */

public class Code_101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isTree(root, root);      //将大的树拆分两棵前节点一样的子树
    }

    private boolean isTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && (isTree(p.left, q.right) && isTree(p.right, q.left));
    }
}
