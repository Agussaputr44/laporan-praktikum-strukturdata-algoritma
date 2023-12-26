//mengimport package scanner java
import java.util.Scanner;

/**
 * Kelas untuk melakukan pencarian squential dalam sebuah array.
 * Saya akan mencari angka/data 45
 * @author Agus saputra
 * 
 */

public class SequentialSearch {
    
    /**
     * Methode untuk melakukan pencarian squential dalam sebuah array.
     * @param arr Array integer yang akan dicari.
     */
    
    public static void Search(int[] arr) {

        Scanner inUs = new Scanner(System.in); // Membuat objek Scanner untuk mengambil input dari pengguna
        int target; // Variabel untuk menyimpan nilai yang akan dicari
        boolean ditemukan = false;

       // Menampilkan elemen-elemen dalam array
       System.out.print("Data: ");
       for (int data : arr) {
           System.out.print(data + " ");
       }

        System.out.print("\nMasukkan nilai yang ingin dicari: "); // Meminta pengguna untuk memasukkan nilai yang ingin dicari
        target = inUs.nextInt(); // Membaca nilai yang dimasukkan oleh pengguna
        inUs.close(); // Menutup objek Scanner 

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Record search: " + arr[i] +  " index: " + i); //menampilkan proses pencarian data(record)
            if (arr[i] == target) { // Memeriksa apakah nilai pada indeks ke-i sama dengan nilai yang dicari
                System.out.println("\nNilai yang dicari berada di indeks: " + i + "\n"); //menampilkan dimana letak data yang di cari
                ditemukan = true; // Mengubah status ditemukan menjadi true jika nilai ditemukan
            }
        }

        if (!ditemukan) { // Memeriksa apakah nilai ditemukan
            System.out.println("\nData yang anda cari tidak ditemukan"); // Menampilkan pesan karena data yang dicari tidak ditemukan
        }
    }

    /**
     * Methode utama untuk menjalankan program.
     *
     * @param args Argumen yang dapat diberikan saat menjalankan program.
     */

    public static void main(String[] args) {

        //membuat data dalam array 
        int[] angka = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90};

        Search(angka); // Memanggil metode Search dengan angka sebagai isi parameter

    }
}
