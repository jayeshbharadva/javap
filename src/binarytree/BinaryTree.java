package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static int ind = -1;

    static int cnt = 0;
    public static node BuildTree(int nodes[]) {
        ind++;
        if (nodes[ind] == -1) {
            return null;
        }
        node newnode = new node(nodes[ind]);
        newnode.left = BuildTree(nodes);
        newnode.right = BuildTree(nodes);

        return newnode;
    }

    public static void print(node root) {
        System.out.println(root.left.data);
    }

    public static void preorder(node root) {
        if (root == null) {
//            System.out.println(-1 + " ");
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void lvlorder(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            node current = q.remove();
            if (current == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(current.data + " ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    public static void lvlsum(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            node current = q.remove();
            if (current == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    System.out.print(cnt);
                    cnt = 0;
                }
            } else {
//                System.out.print(current.data + " ");
                cnt = cnt + current.data;
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    public static int height(node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static int diameter(node root) {
        if (root == null) {
            return 0;
        }
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int h = height(root.left) + height(root.right) + 1;

        return Math.max(h, Math.max(ld, rd));
    }

    public static TreeInfo diam(node root)
    {
        if(root == null)
        {
            return new TreeInfo(0,0);
        }
        TreeInfo left = diam(root.left);
        TreeInfo right = diam(root.right);

        int myht = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1,diam2), diam3);

        return new TreeInfo(myht,mydiam);
    }

    public static boolean isIdentical(node root, node subroot)
    {
        if (root == null && subroot == null)
        {
            return true;
        }

        if(root == null || subroot == null)
        {
            return false;
        }

        if(root.data == subroot.data)
        {
            return isIdentical(root.left,subroot.left) && isIdentical(root.right,subroot.right);
        }
        return false;
    }

    public static boolean isubtree(node root, node subroot)
    {
        if(root == null)
        {
            return false;
        }
        if(subroot == null)
        {
            return true;
        }
        if(isIdentical(root,subroot))
        {
           return true;
        }
        return isubtree(root.left,subroot) || isubtree(root.right,subroot);
    }

    public static class node{
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class TreeInfo {
        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

}
