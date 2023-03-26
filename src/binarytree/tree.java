package binarytree;

public class tree {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,-1,-1,-1,-1,-1,8,-1,9,10,-1,-1,11,-1,12,-1,-1,-1,13,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.node Node;

        Node = tree.BuildTree(arr);

//        BinaryTree.TreeInfo innertree = new BinaryTree.TreeInfo(0,0);
        tree.lvlorder(Node);
        System.out.println();
        tree.lvlsum(Node);

//        BinaryTree.TreeInfo innertree = tree.diam(tree.BuildTree(arr));
//        System.out.println(innertree.diam);
//        System.out.println(innertree.ht);

    }
}