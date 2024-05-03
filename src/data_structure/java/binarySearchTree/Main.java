package data_structure.java.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(50);
        bst.insert(25);
        System.out.println("Contains 30 : " + bst.contains(30));

        bst.rInsert(28);

        System.out.println("Contains 28 : " + bst.contains(28));
        System.out.println("rContains 30 : " + bst.rContains(30));
        System.out.println("rContains 28 : " + bst.rContains(28));

        BinarySearchTree rInsertCheckBST = new BinarySearchTree();
        rInsertCheckBST.rInsert(50);
        rInsertCheckBST.rInsert(25);
        rInsertCheckBST.rInsert(67);
        System.out.println("\n " + rInsertCheckBST.root.value);
        System.out.println(rInsertCheckBST.root.left.value + " " + rInsertCheckBST.root.right.value);

        BinarySearchTree deleteCheckBST = new BinarySearchTree();
        deleteCheckBST.insert(30);
        deleteCheckBST.insert(50);
        deleteCheckBST.insert(25);
        deleteCheckBST.insert(45);
        deleteCheckBST.insert(19);
        deleteCheckBST.insert(28);

        /*
        현재 트리
                30
             25    50
           19 28  45
         */

        deleteCheckBST.deleteNode(30);
        /*
        30 제거 후 예상 트리
                45
             25    50
           19 28  45
         */
        //루트 노드 확인.
        System.out.println("\nRoot : " + deleteCheckBST.root.value);
        System.out.println("Root.left : " + deleteCheckBST.root.left.value + " Root.right : " + deleteCheckBST.root.right.value);
        System.out.println("Root.left.left : " + deleteCheckBST.root.left.left.value + " Root.left.right : " + deleteCheckBST.root.left.right.value);
        System.out.println("Root.right.left : " + deleteCheckBST.root.right.left + " Root.right.right : " + deleteCheckBST.root.right.right);
        System.out.println("기존 45가 있던 자리 : " + deleteCheckBST.root.right.left);

        //BFS 넓이 우선 탐색, DFS 깊이 우선 탐색
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("\nCheck BFS : " + myBST.BFS());
        System.out.println("\nCheck DFSPreOrder : " + myBST.DFSPreOrder());
        System.out.println("\nCheck DFSPostOrder : " + myBST.DFSPostOrder());
        System.out.println("\nCheck DFSPostOrder : " + myBST.DFSInOrder());


    }
}
