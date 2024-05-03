package algorithm.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.printGraph();
        System.out.println("---------");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.printGraph();
        System.out.println("---------");

        graph.remove("A", "B");
        graph.printGraph();
        System.out.println("---------");

        graph.removeVertex("A");
        graph.printGraph();
        System.out.println("---------");
    }
}
