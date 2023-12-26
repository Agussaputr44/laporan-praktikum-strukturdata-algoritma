import java.util.LinkedList;

/**
 * Kelas StringHash mewakili tabel hash sederhana untuk menyimpan string.
 * Kelas ini menggunakan linked list untuk menangani kolisi dan mencakup fungsi hash
 * yang sedikit lebih baik untuk mengurangi kolisi.
 */
class StringHash {

    private LinkedList<String>[] table;

    /**
     * Konstruktor untuk kelas StringHash. Menginisialisasi tabel hash dengan
     * linked list pada setiap indeks.
     *
     * @param size Ukuran tabel hash.
     */
    StringHash(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Fungsi hash yang diperbaiki yang menghitung kode hash untuk string tertentu.
     * Menggunakan rolling hash polinomial sederhana.
     *
     * @param key String yang akan di-hash.
     * @return Kode hash yang dihitung.
     */
    int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % table.length;
        }
        return hash;
    }

    /**
     * Memasukkan string ke dalam tabel hash. Menggunakan kode hash untuk menentukan
     * indeks dan menambahkan string ke linked list pada indeks tersebut.
     *
     * @param value String yang akan dimasukkan.
     */
    void insert(String value) {
        int index = hashFunction(value);
        table[index].add(value);

        System.out.println(value + " Berhasil ditambahkan ke indeks: " + index);
    }

    /**
     * Mencari string dalam tabel hash dan mengembalikan indeksnya.
     *
     * @param value String yang akan dicari.
     * @return Indeks di mana string disimpan dalam tabel hash.
     */
    int search(String value) {
        int index = hashFunction(value);
        return index;
    }

}

/**
 * Kelas HashString berisi metode utama untuk menguji kelas StringHash.
 */
public class HashString {

    /**
     * Metode utama membuat instance dari StringHash, memasukkan beberapa string,
     * dan melakukan operasi pencarian untuk menampilkan perilaku tabel hash.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        // Buat instance dari StringHash dengan ukuran tabel 26
        StringHash table = new StringHash(26);

        // Masukkan beberapa string ke dalam tabel hash
        table.insert("Ayam");
        table.insert("Kambing");
        table.insert("Sapi");
        table.insert("Beruang");
        table.insert("Macan");
        table.insert("Singa");

        // Cari string dan tampilkan indeksnya
        System.out.println(table.search("Ayam"));
        System.out.println(table.search("Kambing"));
        System.out.println(table.search("Sapi"));
    }

}
