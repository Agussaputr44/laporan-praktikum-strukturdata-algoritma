import java.util.*;

/**
 * Kelas DirectedGraph menyediakan implementasi untuk graf berarah menggunakan adjacency list.
 * Setiap node diwakili oleh String dan setiap edge (tepi) hanya memiliki satu arah.
 *
 * @author Agus saputra
 */
class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek DirectedGraph baru.
     */
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Menambahkan node baru ke dalam graf jika belum ada.
     *
     * @param node Nama node yang akan ditambahkan.
     */
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Menambahkan edge (tepi) ke dalam graf dari node sumber ke node tujuan.
     *
     * @param source      Node sumber.
     * @param destination Node tujuan.
     */
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    /**
     * Mendapatkan daftar tetangga (neighbors) dari suatu node.
     *
     * @param node Node yang tetangganya akan diambil.
     * @return Daftar tetangga dari node atau daftar kosong jika node tidak ada dalam graf.
     */
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Mencetak struktur graf, menampilkan setiap node dan tetangganya.
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
     * Metode utama untuk menguji fungsionalitas graf berarah.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak struktur graf
        graph.printGraph();
    }
}
