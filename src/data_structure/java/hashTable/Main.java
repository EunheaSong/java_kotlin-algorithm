package data_structure.java.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("nails", 100);
        ht.set("tile", 70);
        ht.set("lumber", 40);

        ht.printTable();

        System.out.println(ht.get("lumber"));
        System.out.println(ht.get("bolt"));

        System.out.println(ht.keys());

    }
}
