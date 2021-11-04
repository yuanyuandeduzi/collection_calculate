package 树;

import java.util.Scanner;

//ABC##DE#G##F###
public class main {
    private static String s;
    private static int cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        TreeNode root = new TreeNode(s.charAt(0));
        root.left = create_tree();
        root.right = create_tree();
        printQ(root);
        System.out.println();
        printM(root);
        System.out.println();
        printP(root);

    }

    public static TreeNode create_tree() {
        if(s.charAt(cnt) == '#') {
            cnt++;
            return null;
        }
        TreeNode node = new TreeNode(s.charAt(cnt++));
        node.left = create_tree();
        node.right = create_tree();
        return node;
    }

    public static void printQ(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print((char)root.val);
        printQ(root.left);
        printQ(root.right);
    }

    public static void printM(TreeNode root) {
        if (root == null) {
            return;
        }
        printQ(root.left);
        System.out.print((char)root.val);
        printQ(root.right);
    }

    public static void printP(TreeNode root) {
        if (root == null) {
            return;
        }
        printQ(root.left);
        printQ(root.right);
        System.out.print((char) root.val);
    }
}


