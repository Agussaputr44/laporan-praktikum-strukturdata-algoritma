//mengimport package scanner java
import java.util.Scanner;

    /**
    * Kelas untuk melakukan pencarian elemen dalam array menggunakan algoritma Binary Search.
    * Saya akan mencari angka/data 45
    *
    * @author Agus Saputra
    *     
    */

public class BinarySearch {

    /**
     * Pencarian elemen dalam array menggunakan algoritma Binary Search.
     *
     * @param arr Array integer yang akan dicari.
     */

    private static void search(int[] arr) {

        Scanner inUs = new Scanner(System.in); //membuat objek scanner dengan nama inUs
        int find; //variabel untuk menampung nilai yang di cari
        int low = 0; //variabel untuk menyimpan nilai low/nilai awal
        int high = arr.length - 1; //variabel untuk menyimpan nilai high/nilai akhir
        int i = 1; //variabel yang menyimpan hitungan langkah
        boolean ditemukan = false; //variabel untuk menyimpan status data sudah ditemukan atau belum

        // Menampilkan elemen-elemen dalam array
        System.out.print("Data: ");
        for (int data : arr) {
            System.out.print(data + " ");
        }
        //menampilkan index data
        System.out.print("\nIndex: ");
        for(int j = 0; j < arr.length; j++){
            System.out.print(j + "  ");
        }

        //meminta input user untuk memasukkan nilai/angka/data yang di cari
        System.out.print("\nMasukkan nilai yang anda cari: ");
        find = inUs.nextInt(); //menyimpan value input user

        //melakukan looping untuk melakukan pencarian 
        while (!ditemukan) {

            //rumus untuk melakukan binary search
            int mid = (low + high) / 2;

            if (arr[mid] > find) { //melakukan cek kondisi untuk mengetahui posisi angka yang di cari dengan di bandingkan dengan mid(nilai tengah)

                high = mid - 1; //update high untuk melakukan operasi lagi karena mid saat ini lebih besar dari angka yang di cari
                System.out.println("\nlangkah ke: " + i); //menampilkan langkah ke berapa
                System.out.println("mid "+mid+" \n" +arr[mid]+ " > " + find +" \nUpdate High: "+ mid+ " - " + 1 + " = " + high); //print untuk memberikan informasi pengupdatean high 
                i++; //tambah langkah karena akan melakukan langkah lagi untuk pencarian

            } else if (arr[mid] < find) {

                low = mid + 1; //update low untuk melakukan operasi lagi karena mid saat ini lebih kecil dari angka yang di cari
                System.out.println("\nlangkah ke: " + i); //menampilkan langkah ke berapa
                System.out.println("mid "+mid+" \n" +arr[mid]+ " < " + find +" \nUpdate low: "+ mid+ " + " + 1 + " = " + low); //print untuk memberikan informasi pengupdatean high 
                i++; //tambah langkah karena akan melakukan langkah lagi untuk pencarian


            } else {

                System.out.println("\nlangkah ke: " + i); //print untuk mengetahui ditemukan pada langkah ke berapa
                System.out.println("mid "+mid+" \n" +arr[mid]+ " = " + find); //print untuk memberikan informasi pengupdatean high 
                System.out.println("Data ditemukan dalam indeks: " + mid); //menampilkan dimana data yang di cari di temukan
                ditemukan = true; //merubah value ditemukan jadi true agar langkah/loop berhenti

            }
        }

        //cek jika nilai ditemukan tidak berubah jadi true maka akan menampilkan pesan 
        if (!ditemukan) { 
            System.out.println("Data tidak ditemukan dalam array.");
        }

        //menutup scanner
        inUs.close();
    }

    public static void main(String[] args) {

        //membuat data dalam array 
        int[] angka = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90};

        // Memanggil fungsi pencarian dan mengisi parameter dengan nama array
        search(angka); 
    }
}
