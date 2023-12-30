/**
 * Program ini mengimplementasikan algoritma Bubble Sort untuk mengurutkan array bilangan bulat.
 * Pengguna diminta untuk memasukkan ukuran array dan angka-angka acak,
 * dan program akan mencetak array sebelum dan setelah diurutkan.
 *
 * @author Agus Saputra
 */
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    /**
     * Mengurutkan array bilangan bulat menggunakan algoritma Bubble Sort.
     *
     * @param arr Array yang akan diurutkan.
     */
    static void Bubble(int arr[]) {
        // Iterasi luar untuk melintasi seluruh array
        for (int i = 0; i < arr.length; i++) {
            // Iterasi dalam untuk melakukan perbandingan dan pertukaran pasangan
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Jika elemen saat ini lebih besar dari elemen berikutnya, tukar mereka
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Metode utama di mana program dimulai eksekusinya.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner inus = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan ukuran array
        System.out.print("Masukkan ukuran array: ");
        int size = inus.nextInt();

        // Membuat array untuk menyimpan angka-angka acak
        int arr[] = new int[size];

        // Meminta pengguna untuk memasukkan angka-angka acak
        System.out.print("Masukkan angka-angka acak Anda: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = inus.nextInt();
        }

        // Menampilkan array sebelum diurutkan
        System.out.println("Array sebelum diurutkan: " + Arrays.toString(arr));

        // Memanggil metode Bubble Sort untuk mengurutkan array
        Bubble(arr);

        // Menampilkan array setelah diurutkan
        System.out.println("Array setelah diurutkan: " + Arrays.toString(arr));

        // Menutup scanner untuk mencegah kebocoran sumber daya
        inus.close();
    }
}
