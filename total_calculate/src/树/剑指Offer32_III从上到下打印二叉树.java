package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
*       题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *      例如:
 *      给定二叉树:[3,9,20,null,null,15,7]
 *      输出：[[3],[20,9],[15,7]]
* */

/*
*       题解：层序遍历的变化，从上至下，一层按从头至尾遍历，下一层按从尾至头遍历，依次循环往复，从上至下遍历二叉树，按照正常层序遍历方法遍历二叉树。
*       添加flag用于辨别此层是从前至尾还是从尾至头遍历，采用LinkedList集合，存储本层的值，通过其头插尾插实现值的顺序存储。每存储一层，更新flag的
*       值。
* */

public class 剑指Offer32_III从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        boolean flag = true;
        while(!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if(flag) {
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}
