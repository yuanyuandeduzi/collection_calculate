package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
*       题目：序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另
 *       一个计算机环境，采取相反方式重构得到原数据。
 *
 *       请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串
 *       并且将这个字符串反序列化为原始的树结构。
 *
 *       提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
 *       方法解决这个问题。
* */

/*
*       题解：
*       序列化方法的编写思路，我们使用层序遍历的方式遍历二叉树，依次将每层的节点拿出，将节点的val存入一个字符串中，并用逗号间隔，此处间隔
*       用于在反序列化的过程中区分各个节点的值，辨别有多少节点，我们将最子叶节点左右的null用空格表示。最终层序遍历结束，此时我们将得到一个由逗号
*       间隔的字符串，此字符串从左至右依次存储每层节点，且每层的节点顺序为从左至右（与二叉树一致）
*
*       反序列化方法编写思路：根据输入的序列化字符串，我们以逗号为分割将每个节点分割出来，由于此节点顺序严格遵循树的从左至右顺序，所以若字符串不为
*       空，则树的根节点为分割后字符串的第一个字符子串，然后按照层序遍历的思路区构造二叉树，若当前子字符为空，则表示当前节点为null，层序遍历完成
*       完成二叉树的构造
* */

public class Code_297二叉树的序列化与反序列化 {

    public static void main(String[] args) {        //测试程序
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = null;
        treeNode1.right = null;
        root.left = treeNode1;
        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(4);
        treeNode2.right = new TreeNode(5);
        root.right = treeNode2;
        System.out.println(serialize(root));
        System.out.println(serialize(deserialize(serialize(root))));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        } else {
            ans.append(' ');
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    ans.append(node.val).append(',');
                } else {
                    ans.append(' ').append(',');
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.charAt(0) == ' ') {
            return null;
        }
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int n = 0;
        TreeNode root = new TreeNode(Integer.parseInt(split[n++]));
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (!split[n].equals(" ")) {
                    node.left = new TreeNode(Integer.parseInt(split[n++]));
                    queue.add(node.left);
                } else {
                    n++;
                }
                if (!split[n].equals(" ")) {
                    node.right = new TreeNode(Integer.parseInt(split[n++]));
                    queue.add(node.right);
                } else {
                    n++;
                }
            }
        }
        return root;
    }
}
