import java.util.*;

/**
 * Kelas Sisi merepresentasikan tepi (edge) dalam graf dengan menyimpan tujuan (destination) dan bobot (weight).
 */
class Sisi {
    String destination;
    int weight;

    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

/**
 * Kelas DijkstraGraphTraversal menyediakan implementasi algoritma Dijkstra untuk traversal graf.
 * Graf direpresentasikan menggunakan daftar keberadjungan (adjacency list).
 * Setiap node diwakili oleh sebuah String dan setiap tepi memiliki bobot.
 * Kelas ini dapat menemukan jarak terpendek dari suatu node awal ke node akhir dalam graf.
 *
 * @author Agus Saputra
 */
public class DijkstraGraphTraversal {
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    /**
     * Menambahkan node ke dalam graf jika belum ada.
     *
     * @param node Nama node yang akan ditambahkan.
     */
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Menambahkan tepi (edge) ke dalam graf dengan bobot tertentu.
     * Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
     *
     * @param source      Node asal.
     * @param destination Node tujuan.
     * @param weight      Bobot dari tepi.
     */
    public void addEdge(String source, String destination, int weight) {
        addNode(source);
        addNode(destination);

        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    /**
     * Algoritma Dijkstra untuk mencari jarak terpendek dari suatu node awal ke node akhir dalam graf.
     *
     * @param start Node awal.
     * @param end   Node akhir.
     * @return Jarak terpendek dari node awal ke node akhir.
     */
    public int dijkstra(String start, String end) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<String, Integer> distances = new HashMap<>();
        Set<String> settled = new HashSet<>();

        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();
            if (current.equals(end)) {
                return distances.get(end);
            }

            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!settled.contains(edge.destination)) {
                    int newDistance = distances.get(current) + edge.weight;
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        return distances.get(end);
    }

    /**
     * Metode utama untuk menguji algoritma Dijkstra pada graf tertentu.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();

        // Tambahkan node dan edge sesuai dengan graf Anda
        // Contoh: graph.addEdge("A", "B", 6);

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);

        // Temukan dan tampilkan jarak terpendek dari NodeAwal ke NodeAkhir
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}
