//mengimport package scanner java
import java.util.Scanner;

/**
 * class untuk melakukan interpolation search dalam array
 * Saya akan mencari angka/data 45
 * @author Agus saputra
 * 
 */

public class InterpolationSearch {

    /**
     * Fungsi untuk melakukan interpolation search dalam sebuah array.
     *
     * @param arr array integer yang akan dicari.
     * 
     */

    static void interpolationSearch(int[] arr) {

        Scanner inUs = new Scanner(System.in); //membuat objek scanner
        int low = 0; //declare low dengan nilai 0, karena setiap array pasti index pertamanya adalah 0
        int high = arr.length - 1; //declare high dengan nilai panjang array -1, karena array dimulai dari 0 jadi perhitungannya berbeda, di kurangi satu dari total elemen
        int i = 1; //declare untuk hitungan loop
        int target; //declare target dengan int
        int mid; //declare mid dengan int
        boolean ditemukan = false; //declare ditemukan dengan value false

        
        System.out.print("Masukkan nilai yang anda cari: "); //meminta user untuk menginputkan nilai yang dicari
        target = inUs.nextInt();//menyimpan nilai dari input user
        inUs.close();//menutup scanner

        System.out.println("Rumus:\nmid = low + ((high - low) * (target - arr[low])) / (arr[high] - arr[low])"); //menampilkan rumus dari interpolation search

        //loop untuk melakukan pencarian 
        while (low <= high && target >= arr[low] && target <= arr[high]) {

            System.out.println("\nlangkah ke: " + i++); //print hitungan langkah
            System.out.println("low: " + low); //print nilai low
            System.out.println("high: " + high); //print nilai high
            System.out.println("arr low: " + arr[low]); //print isi data di low array
            System.out.println("arr high: " + arr[high]); //print isi data di high array
            
            // Hitung mid dengan interpolation rumus
            mid = low + ((high - low) * (target - arr[low])) / (arr[high] - arr[low]);
            System.out.println(low + " + (( " + high + " - " + low + ") * ( " + target + " - " + arr[low] + ")) / ( " + arr[high] + " - " + arr[low] + ")" );
            System.out.println(low + " + ( " + (high-low) + " * " + (target-arr[low]) + ") / " + ( arr[high] - arr[low]) ); //menampilkan proses perhitungan mid dengan rumus
            System.out.println(low + " + ( " + (high-low) * (target-arr[low]) + ") / " + ( arr[high] - arr[low]) ); //menampilkan proses perhitungan mid dengan rumus
            System.out.println("mid: " + mid); //print nilai mid
            
            //melakukan pengecekan terhadap nilai dari mid dan target dengan operator comparation
            if (arr[mid] == target) {

                System.out.println(arr[mid] + " = " + target); //menampilkan value dari mid = nilai yang dicari
                System.out.print("Nilai yang anda cari ada pada index: " + mid); //menampilkan pesan dimana letak nilai yang dicari 
                ditemukan = true; //mengubah nilai ditemukan menjadi true agar blok kode 'data tidak ditemukan' tidak diekseskusi
                break; //berhenti mencari karena sudah didapatkan nilainya/indeksnya

            }else if (arr[mid] < target) { 

                System.out.println(arr[mid] + " < " + target); //menampilkan nilai dari mid lebih kecil dari nilai yang dicari
                low = mid + 1; // Cari di bagian kanan dengan cara update low
                System.out.println("Update low: "+ mid + " + " + "1 = "  + low ); //menampilkan bagaimana cara update low
                
            } else {

                System.out.println(arr[mid] + " > " + target); //menampilkan nilai dari mid lebih besar dari nilai yang dicari
                high = mid - 1; // Cari di bagian kiri dengan cara update high
                System.out.println("Update high: "+ mid + " - " + "1 = "  + high ); //menampilkan bagaimana cara update high

            }
        }

        //melakukan pengecekan untuk nilai ditemukan, jika tetap false maka akan menampilkan pesan dibawah ini
        if(!ditemukan){ 
            System.out.println("Nilai yang anda cari tidak ditemukan"); //menampilkan pesan karena data tidak ditemukan
        }

    }

    /**
     * 
     * methode main untuk menjalankan program
     * @param args adalah paramater default untuk main methode
     */

    public static void main(String[] args) {

        //membuat array dengan data yang sudah ditentukan
        int[] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90}; 

        //menampilkan semua elemen array
        for (int i : arr) {
            System.out.print(i + " ");
            
        }

        System.out.println("\n");

        //memanggil methode interpolationsearch dan mengisi parameter dengan nama array yang telah dibuat
        interpolationSearch(arr);
    }
}
