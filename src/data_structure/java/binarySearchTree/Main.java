package data_structure.java.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(50);
        bst.insert(25);

        System.out.println("Contains 30 : " + bst.contains(30));
        System.out.println("Contains 40 : " + bst.contains(40));
        System.out.println("rContains 25 : " + bst.rContains(25));

        bst.rInsert(28);
        System.out.println("rContains 28 : " + bst.rContains(28));

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.rInsert(50);
        bst2.rInsert(25);
        bst2.rInsert(67);
        System.out.println(" " + bst2.root.value);
        System.out.println(bst2.root.left.value + " " + bst2.root.right.value);

        bst.insert(45);
        bst.insert(19);
        /*
        현재 트리
                30
             25    50
           19 28  45
         */

        bst.deleteNode(30);
        /*
        30 제거 후 예상 트리
                45
             25    50
           19 28  45
         */
        //루트 노드 확인.
        System.out.println("Root : " + bst.root.value);
        System.out.println("Root.left : " + bst.root.left.value + " Root.right : " + bst.root.right.value);
        System.out.println("Root.left.left : " + bst.root.left.left.value + " Root.left.right : " + bst.root.left.right.value);
        System.out.println("Root.right.left : " + bst.root.right.left + " Root.right.right : " + bst.root.right.right);
        System.out.println("기존 45가 있던 자리 : " + bst.root.right.left);

    }
}
