/**
 * Program ini mengimplementasikan penelusuran graf menggunakan algoritma Breadth-First Search (BFS).
 * Graf direpresentasikan menggunakan struktur data daftar keberadjungan dan setiap node memiliki
 * daftar tetangga dan bobot yang terhubung dengannya.
 *
 * @author Agus saputra
 */
import java.util.*;

/**
 * Kelas Edges merepresentasikan tepi graf dengan tujuan dan bobot.
 */
class Edges {
    String destination;
    int weight;

    /**
     * Konstruktor untuk membuat tepi dengan tujuan dan bobot tertentu.
     *
     * @param destination Tujuan dari tepi.
     * @param weight      Bobot dari tepi.
     */
    public Edges(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

/**
 * Kelas BfsGraphTraversal merepresentasikan graf dan menyediakan metode untuk menambahkan node,
 * menambahkan tepi berbobot, mendapatkan tetangga dari suatu node, dan melakukan penelusuran graf
 * menggunakan algoritma BFS.
 */
public class BfsGraphTraversal {
    private Map<String, List<Edges>> adjacencyList;

    /**
     * Konstruktor untuk membuat objek graf dengan daftar keberadjungan kosong.
     */
    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Metode untuk menambahkan node baru ke dalam graf.
     *
     * @param node Nama node yang akan ditambahkan.
     */
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Metode untuk menambahkan tepi berbobot antara dua node dalam graf.
     *
     * @param source      Node sumber.
     * @param destination Node tujuan.
     * @param weight      Bobot dari tepi.
     */
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    /**
     * Metode untuk mendapatkan daftar tetangga dan bobot dari suatu node.
     *
     * @param node Node yang ingin diketahui tetangganya.
     * @return Daftar tetangga dan bobotnya.
     */
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Metode untuk melakukan penelusuran graf menggunakan algoritma Breadth-First Search (BFS).
     * Dimulai dari node awal (start), program akan mencetak urutan penelusuran.
     *
     * @param start Node awal penelusuran.
     */
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            // Menambahkan semua tetangga yang belum dikunjungi ke antrian
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    /**
     * Metode utama untuk menguji penelusuran graf BFS.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.bfsTraversal("A");
    }
}
