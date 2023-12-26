/**
 * Kelas Hash mewakili tabel hash sederhana yang menyimpan nilai integer.
 * Tabel hash ini menggunakan array untuk menyimpan nilai pada indeks yang
 * sesuai dengan nilai tersebut.
 * @author Agus saputra
 */
class Hash {

    private int[] table;

    /**
     * Konstruktor untuk kelas Hash. Menciptakan tabel hash dengan ukuran tertentu.
     *
     * @param size Ukuran tabel hash.
     */
    Hash(int size) {
        table = new int[size];
    }

    /**
     * Memasukkan nilai integer ke dalam tabel hash pada indeks yang sesuai.
     *
     * @param value Nilai integer yang akan dimasukkan.
     */
    void insert(int value) {
        int index = value;
        table[index] = value;

        System.out.println("Angka: " + value + " ditambahkan ke dalam indeks: " + index);
    }

    /**
     * Mencari nilai integer dalam tabel hash dan menampilkan indeksnya jika ditemukan.
     *
     * @param value Nilai integer yang akan dicari.
     */
    void search(int value) {
        if (table[value] == value) {
            System.out.println("Angka " + table[value] + " berada pada indeks: " + value);
        }

        System.out.println("Angka: " + value + " tidak ada di dalam tabel.");
    }
}

/**
 * Kelas DirectHash berisi metode utama untuk menguji kelas Hash.
 */
public class DirectHash {

    /**
     * Metode utama membuat instance dari kelas Hash, memasukkan beberapa nilai integer,
     * dan melakukan operasi pencarian untuk menampilkan perilaku tabel hash.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {

        // Buat instance dari kelas Hash dengan ukuran tabel 200
        Hash table = new Hash(200);

        // Masukkan beberapa nilai integer ke dalam tabel hash
        table.insert(199);
        table.insert(100);
        table.insert(120);
        table.insert(122);
        table.insert(130);

        // Cari nilai integer dan tampilkan indeksnya
        table.search(9);
        table.search(20);
    }
}
