package 树;

import java.util.Scanner;

//ABC##DE#G##F###
public class main {
    private static String s;
    private static int cnt = 0;
    private static String ans = "";
    private static int n1 = 0;
    private static int n2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        TreeNode root = create_tree();
        System.out.println(maxDepthG(root));
    }
    public static int maxDepthG(TreeNode root) {       //尽可能深的搜索树，在回溯时完成深度值的统计
        if(root == null) return 0;
        return Math.max(maxDepthG(root.left), maxDepthG(root.right)) + 1;
    }
    public static TreeNode create_tree() {
        if (s.charAt(cnt) == '#') {
            cnt++;
            return null;
        }
        TreeNode node = new TreeNode(s.charAt(cnt++));
        node.left = create_tree();
        node.right = create_tree();
        return node;
    }
}


