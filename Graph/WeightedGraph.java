import java.util.*;

/**
 * Kelas WeightedGraph merepresentasikan directed graph (graf berarah) berbobot menggunakan adjacency list.
 * @author Agus saputra
 */
class Edge {
    String destination;
    int weight;

    /**
     * Konstruktor untuk membuat objek Edge (sisi) dengan tujuan dan bobot tertentu.
     *
     * @param destination Node tujuan sisi.
     * @param weight      Bobot sisi.
     */
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

/**
 * Kelas WeightedGraph merepresentasikan directed graph (graf berarah) berbobot menggunakan adjacency list.
 */
class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek WeightedGraph.
     */
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Metode untuk menambahkan node baru ke dalam graf.
     *
     * @param node Node yang akan ditambahkan.
     */
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Metode untuk menambahkan edge berbobot ke dalam graf.
     *
     * @param source      Node sumber sisi.
     * @param destination Node tujuan sisi.
     * @param weight      Bobot sisi.
     */
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    /**
     * Metode untuk mencetak graf, menampilkan node-node terhubung beserta bobotnya.
     */
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    /**
     * Metode main untuk menjalankan dan menguji fungsionalitas directed graph berbobot.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge atau sisi ke graf
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak graf
        graph.printGraph();
    }
}
