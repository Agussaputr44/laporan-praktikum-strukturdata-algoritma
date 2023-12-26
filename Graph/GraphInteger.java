import java.util.*;

/**
 * Kelas SimpleGraph menyediakan implementasi untuk graf sederhana menggunakan adjacency list.
 * Setiap node diwakili oleh Integer dan setiap edge (tepi) dapat memiliki dua arah (graf tidak terarah).
 *
 * @author Agus saputra
 */
class SimpleGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek SimpleGraph baru.
     */
    public SimpleGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Menambahkan node baru ke dalam graf jika belum ada.
     *
     * @param node Nilai node yang akan ditambahkan.
     */
    public void addNode(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Menambahkan edge (tepi) ke dalam graf dari node sumber ke node tujuan.
     *
     * @param source      Node sumber.
     * @param destination Node tujuan.
     */
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    /**
     * Mendapatkan daftar tetangga (neighbors) dari suatu node.
     *
     * @param node Node yang tetangganya akan diambil.
     * @return Daftar tetangga dari node atau daftar kosong jika node tidak ada dalam graf.
     */
    public List<Integer> getNeighbors(int node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Mencetak struktur graf, menampilkan setiap node dan tetangganya.
     */
    public void printGraph() {
        for (int node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    /**
     * Metode utama untuk menguji fungsionalitas graf sederhana.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        // Mencetak struktur graf
        graph.printGraph();
    }
}
