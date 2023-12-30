/**
 * Program ini mengimplementasikan algoritma Selection Sort untuk mengurutkan array bilangan bulat.
 * Array akan diurutkan dalam urutan naik.
 *
 * @author Agus saputra
 */
public class SelectionSort {

    /**
     * Metode utama di mana program dimulai eksekusinya.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 8, 9, 90};

        // Memanggil metode selectionSort untuk mengurutkan array
        selectionSort(array);

        // Menampilkan array setelah diurutkan
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Metode untuk mengurutkan array menggunakan algoritma Selection Sort.
     *
     * @param array Array yang akan diurutkan.
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            // Mencari nilai minimum dalam array yang belum diurutkan
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Menukar elemen terkecil dengan elemen pertama dalam array yang belum diurutkan
            int buffer = array[i];
            array[i] = array[minIndex];
            array[minIndex] = buffer;
        }
    }
}
