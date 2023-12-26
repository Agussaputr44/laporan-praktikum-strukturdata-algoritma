import java.util.*;

/**
 * Kelas UndirectedGraph merepresentasikan graf tidak terarah menggunakan adjacency list.
 * @author Agus saputra
 */
class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek UndirectedGraph.
     */
    public UndirectedGraph() {
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
     * Metode untuk menambahkan edge ke dalam graf.
     * (Ditambahkan di kedua arah untuk graf tidak terarah)
     *
     * @param source      Node sumber sisi.
     * @param destination Node tujuan sisi.
     */
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /**
     * Metode untuk mendapatkan daftar tetangga dari suatu node.
     *
     * @param node Node yang ingin diketahui tetangganya.
     * @return Daftar tetangga dari node.
     */
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Metode untuk mencetak graf.
     */
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    /**
     * Metode main untuk menjalankan dan menguji fungsionalitas graf tidak terarah.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        // Menambahkan node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge atau sisi ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak graf
        graph.printGraph();
    }
}
