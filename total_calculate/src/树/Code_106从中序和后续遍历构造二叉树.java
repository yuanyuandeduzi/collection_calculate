package 树;

import java.util.HashMap;

/**
 *      题目：根据一棵树的中序遍历与后序遍历构造二叉树。
 *      注意:
 *      你可以假设树中没有重复的元素。
 *      例：中序遍历 inorder = [9,3,15,20,7]
 *         后序遍历 postorder = [9,15,7,20,3]
* */

/*
*       题解：我们由二叉树的遍历规则可知，后序遍历的最后一个节点为此二叉树的根节点，而对于中序遍历来说，假使我们在此数组中找到了一个根节点，那么在此根节点的
*       左边为此根节点左树的所有节点，其右边为其右子树的所有节点，对于中序和后续的遍历结果我们都可以将其分为三部分，根节点，左子树，右子树，所以我们可以通过
*       后续遍历找到根节点的数，在根据根的数值找到其中序遍历结果中的位置，根据中序遍历确定左右子树节点的个数，从而我们可以将问题再分割，分割为为当前节点构建
*       其的左右子树，而其步骤与此一样。定义全局变量HashMap<Integer, Integer> map，用于将中序遍历的位置与值匹配起来便于查询。
*       定义递归方法TreeNode(int ms, int me, int ps, int pe),递归方法的功能为通过中序遍历和后序遍历结果构建树，然后将书的更节电返回，参数为中序遍
*       历结果的前后边界ms,me，后续遍历的前后边界ps,pe，后续遍历的数组，递归思路为通过pe找到根节点数值，再通过根节点数值通过map找到其再中序遍历中的位置ri,
*       通过ri,我们可以将其分割为左右子树，分割方法为对于中序有，左子树长度为 ri - ms,对于中序来说  左子树范围为 （ms,ri - 1）,右子树为 (ri + 1, me),
*       对于后序来说 左子树范围为 （ps, ps + ri - ms - 1），右子树范围为 （ps + ri - ms, pe - 1）, 然后递归为当前根节点构建左右子树，递归方法退出
*       条件为左子树为null,或者右子树为null,返回null.
* */

public class Code_106从中序和后续遍历构造二叉树 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = 0;
        for (int i : inorder) {
            map.put(i, n++);
        }
        return builder(0,inorder.length - 1,0,postorder.length - 1,postorder);
    }

    public TreeNode builder(int ms, int me, int ps, int pe,  int[] postorder) {
        if (ps > pe || ms > me) {
            return null;
        }
        int ri = map.get(postorder[pe]);
        TreeNode root = new TreeNode(postorder[pe]);

        root.left = builder(ms, ri - 1, ps, ps + ri - ms - 1,  postorder);      //不能惯性思维
        root.right = builder(ri + 1, me, ps + ri - ms, pe - 1, postorder);
        return root;
    }
}
