/**
 * Program ini mengimplementasikan algoritma Insertion Sort untuk mengurutkan array bilangan bulat.
 * Array akan diurutkan dalam urutan naik.
 *
 * @author Agus saputra
 */
import java.util.Arrays;

public class InsertionSort {
    /**
     * Metode untuk mengurutkan array menggunakan algoritma Insertion Sort.
     *
     * @param arr Array yang akan diurutkan.
     */
    static void sort(int arr[]) {
        int n = arr.length;

        // Iterasi melalui seluruh array, dimulai dari elemen kedua (indeks 1)
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Geser elemen-elemen yang lebih besar dari key ke posisi satu di depannya
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Tempatkan key di posisi yang benar dalam array
            arr[j + 1] = key;
        }
    }

    /**
     * Metode utama di mana program dimulai eksekusinya.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        // Memanggil metode sort untuk mengurutkan array
        sort(arr);

        // Menampilkan array setelah diurutkan
        System.out.println("Array setelah diurutkan: " + Arrays.toString(arr));
    }
}
