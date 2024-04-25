package data_structure.java.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(50);
        bst.insert(25);

        System.out.println(bst.contains(30));
    }
}
