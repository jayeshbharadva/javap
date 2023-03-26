package binarytree;

public class BST {

    static class node{
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static node delete(node root, int val) {
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else //(val == root.data)
        {
//            case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
//            case 3

            node Is = inordersuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right,Is.data);
        }
        return root;
    }

    public static node inordersuccessor(node root)
    {
            while (root.left != null)
            {
                root = root.left;
            }
            return root;
        }

    public static node insert(node root, int val) {
        if (root == null) {
            root = new node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(node root)
    {
        node temp = root;
        if(temp == null)
        {
            return;
        }
        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    public static boolean search(node root, int key)
    {
        node temp = root;

        if(root == null)
        {
            return false;
        }

        if (temp.data == key)
        {
            return true;
        }
        if (key < temp.data)
        {
            return search(temp.left , key);
        }
        else
        {
            return search(temp.right, key);
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 1, 2, 7, 4, 6};

        node root = null;
        for (int i = 0; i < arr.length; i++)
        {
            root = insert(root,arr[i]);
        }
        inorder(root);
//        System.out.println(search(root,0));
        System.out.println();
        root = delete(root,3);
        inorder(root);
    }
}
