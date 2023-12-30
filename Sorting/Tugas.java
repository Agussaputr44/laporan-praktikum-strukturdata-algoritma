import java.util.Arrays;

/**
 * @author Agus Saputra
 * @author Andri Ahmad
 * @author Bayu Dani Kurniawan
 * @author Dewi Kartika Siahaan
 * Program ini mengurutkan elemen dalam sebuah array String 
 * menggunakan algoritma bubble sort.
 */
public class Tugas {

  /**
   * Fungsi sort menerima sebuah array String dan 
   * mengurutkannya secara ascending menggunakan bubble sort.
   * 
   * @param arr array String yang akan diurutkan
   */
  static void sort(String[] arr){

    // lakukan perulangan bubble sort
    for (int i = 0; i < arr.length - 1; i++) {
      
      // perulangan dalam
      for (int j = 0; j < arr.length - i - 1; j++) {

        // bandingkan dua elemen yang bersebelahan
        // jika tidak urut, tukar posisinya
        if (arr[j].compareTo(arr[j + 1]) > 0) {

          String temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /**
   * Fungsi main untuk menjalankan program
   *
   * @param args argumen program
   */
  public static void main(String[] args) {

    String[] strings = {"dewi", "agus", "bayu", "andri"};

    // panggil fungsi sort untuk mengurutkan array
    sort(strings);

    // cetak hasil pengurutan
    System.out.println(Arrays.toString(strings));

  }
}