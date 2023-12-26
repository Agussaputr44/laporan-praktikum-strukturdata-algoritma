/**
 * Kelas Step mewakili tabel hash dengan penanganan kolisi menggunakan metode langkah (linear probing).
 * Tabel hash ini menyimpan nilai integer dan menangani kolisi dengan cara mencari langkah selanjutnya jika
 * terjadi kolisi pada suatu indeks.
 * @author Agus saputra
 */
class Step {

    private int[] table;
    private int step = 1;

    /**
     * Konstruktor untuk kelas Step. Menciptakan tabel hash dengan ukuran tertentu.
     *
     * @param size Ukuran tabel hash.
     */
    Step(int size) {
        table = new int[size];
    }

    /**
     * Memasukkan nilai integer ke dalam tabel hash dengan menangani kolisi menggunakan metode langkah (linear probing).
     *
     * @param value Nilai integer yang akan dimasukkan.
     */
    void insert(int value) {
        int index = value % table.length;
        while (table[index] != 0) {
            System.out.println("Data: " + value + " mengalami kolisi pada kunci: " + index);
            index = (index + step) % table.length;
            System.out.println("Digeser ke indeks: " + index);
        }
        table[index] = value;
        System.out.println("Data: " + value + " dimasukkan ke indeks: " + index);
    }

    /**
     * Mencari nilai integer dalam tabel hash dan menampilkan indeksnya jika ditemukan.
     *
     * @param value Nilai integer yang akan dicari.
     */
    void search(int value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == value) {
                System.out.println("Angka ditemukan di indeks: " + i);
                return;
            }
        }
        System.out.println("Angka tidak ditemukan.");
    }
}

/**
 * Kelas StepHash berisi metode utama untuk menguji kelas Step.
 */
public class StepHash {

    /**
     * Metode utama membuat instance dari kelas Step, memasukkan beberapa nilai integer,
     * dan melakukan operasi pencarian untuk menunjukkan cara penanganan kolisi menggunakan metode langkah.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {

        // Buat instance dari kelas Step dengan ukuran tabel 8
        Step stepHash = new Step(8);

        // Masukkan beberapa nilai integer ke dalam tabel hash
        stepHash.insert(1);
        stepHash.insert(30);
        stepHash.insert(75);
        stepHash.insert(25);

        // Cari nilai integer dan tampilkan indeksnya
        stepHash.search(30);
    }
}
