import java.util.*;

/**
 * Kelas StringGraph menyediakan implementasi untuk graf menggunakan adjacency list
 * dengan node yang direpresentasikan oleh String dan edge (tepi) dapat memiliki
 * dua arah (graf tidak terarah).
 *
 * @author Agus saputra
 */
class StringGraph {
    private Map<String, List<String>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek StringGraph baru.
     */
    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Menambahkan node baru ke dalam graf jika belum ada.
     *
     * @param node Nilai node yang akan ditambahkan.
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
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
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
     * Metode utama untuk menguji fungsionalitas graf menggunakan String sebagai node.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        StringGraph graph = new StringGraph();
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
