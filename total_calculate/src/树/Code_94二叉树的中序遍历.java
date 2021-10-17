package 树;

import java.util.ArrayList;
import java.util.List;

/**
*       题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
*       示例：
*       二叉树：[3,9,20,null,null,15,7]
*       返回其层序遍历结果:
*        [
*        [3],
*        [9,20],
*        [15,7]
*        ]
* */

/*
*       题解：与前序遍历一样马，只是先进性左节点的遍历，再进行当前节点的输出，在进行右节点的遍历，在节点为null时，return,再回溯时完成指的输出，
* */

public class Code_94二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        print(root,list);
        return list;
    }

    public void print(TreeNode root, List<Integer> list) {
        if(root == null) {
            return ;
        }
        print(root.left,list);
        list.add(root.val);
        print(root.right,list);
    }

}
