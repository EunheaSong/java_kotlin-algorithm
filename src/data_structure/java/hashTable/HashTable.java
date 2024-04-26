package data_structure.java.hashTable;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("    {" + temp.key + " = " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
            //length 로 나눈 나머지의 값은 0 ~ length-1 중에서만 나온다!!(무조건 배열의 인덱스 값 중 하나가 나옴.)
        }
        return hash;
    }



}
