package Tugas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Mahasiswa merepresentasikan entitas mahasiswa dengan NIM, nama, dan jurusan.
 * 
 * <p>
 * Kelas Main merupakan kelas utama yang menyediakan menu untuk pengguna.
 * Pengguna dapat menambahkan, menampilkan, dan menghapus data mahasiswa.
 * Selain itu, terdapat opsi untuk melakukan pencarian menggunakan binary search,
 * sequential search, dan interpolation search berdasarkan NIM mahasiswa.
 * </p>
 * 
 * @author Agus saputra
 */
class Mahasiswa {

    private String NIM;
    private String name;
    private String jurusan;

    /**
     * Konstruktor untuk membuat objek Mahasiswa dengan NIM, nama, dan jurusan.
     *
     * @param NIM     NIM mahasiswa.
     * @param name    Nama mahasiswa.
     * @param jurusan Jurusan mahasiswa.
     */
    Mahasiswa(String NIM, String name, String jurusan) {
        this.NIM = NIM;
        this.name = name;
        this.jurusan = jurusan;
    }

    /**
     * Metode untuk mendapatkan NIM mahasiswa.
     *
     * @return String NIM mahasiswa.
     */
    String getNIM() {
        return NIM;
    }

    /**
     * Metode untuk mendapatkan nama mahasiswa.
     *
     * @return String Nama mahasiswa.
     */
    String getName() {
        return name;
    }

    /**
     * Metode untuk mendapatkan jurusan mahasiswa.
     *
     * @return String Jurusan mahasiswa.
     */
    String getJurusan() {
        return jurusan;
    }
}

/**
 * Kelas Main adalah kelas utama yang berisi menu dan logika aplikasi.
 */
public class Main {

    static Scanner inUs = new Scanner(System.in);

    /**
     * Metode untuk menambahkan data mahasiswa ke dalam ArrayList.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void tambahData(ArrayList<Mahasiswa> arr) {

        System.out.print("Masukkan NIM: ");
        inUs.nextLine();
        String nim = inUs.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = inUs.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = inUs.nextLine();

        arr.add(new Mahasiswa(nim, nama, jurusan));
        System.out.println("Data berhasil ditambahkan");
    }

    /**
     * Metode untuk menampilkan data mahasiswa dari ArrayList.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void tampilkanData(ArrayList<Mahasiswa> arr) {

        System.out.println("+-----------------------------------------------------------------------------------+");
        System.out.println("|       Nama         |          NIM           |              Jurusan                |");
        System.out.println("+-----------------------------------------------------------------------------------+");

        for (Mahasiswa mhs : arr) {
            System.out.printf("|  %-16s  |   %-19s  |    %-30s   |\n", mhs.getName(), mhs.getNIM(), mhs.getJurusan());
        }

        System.out.println("+-----------------------------------------------------------------------------------+");
    }

    /**
     * Metode untuk menghapus data mahasiswa dari ArrayList berdasarkan NIM.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void hapusData(ArrayList<Mahasiswa> arr) {

        inUs.nextLine();
        System.out.print("Masukkan NIM dari data yang ingin anda hapus: ");
        String delNim = inUs.nextLine();

        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i).getNIM().equals(delNim)) {
                arr.remove(i).getNIM();
                System.out.println("Data berhasil dihapus");
                return;
            }

            System.out.println("NIM yang anda masukkan tidak valid");
        }
    }

    /**
     * Metode untuk melakukan pencarian data mahasiswa menggunakan interpolation search
     * berdasarkan NIM.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void interpolationSearch(ArrayList<Mahasiswa> arr) {

        inUs.nextLine();

        System.out.print("Masukkan NIM yang anda cari: ");
        String find = inUs.nextLine();

        int low = 0, high = arr.size() - 1;

        while (low <= high && arr.get(low).getNIM().compareTo(find) <= 0
                && arr.get(high).getNIM().compareTo(find) >= 0) {

            String lowNIM = arr.get(low).getNIM();
            String highNIM = arr.get(high).getNIM();

            int mid = low + ((find.compareTo(lowNIM) * (high - low)) / (highNIM.compareTo(lowNIM)));

            if (arr.get(mid).getNIM().equals(find)) {
                System.out.println("NIM ditemukan pada indeks ke-" + mid);
                return;
            } else if (arr.get(mid).getNIM().compareTo(find) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("NIM tidak ditemukan.");
    }

    /**
     * Metode untuk melakukan pencarian data mahasiswa menggunakan binary search
     * berdasarkan NIM.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void binarySearch(ArrayList<Mahasiswa> arr) {

        inUs.nextLine();

        int low = 0, high = arr.size() - 1, mid;
        boolean ditemukan = false;

        System.out.print("Masukkan NIM yang anda cari: ");
        String find = inUs.nextLine();

        while (!ditemukan && low <= high) {

            mid = (low + high) / 2;

            int hasilCompare = arr.get(mid).getNIM().compareTo(find);

            if (hasilCompare == 0) {
                System.out.println("NIM ditemukan pada indeks ke-" + mid);
                ditemukan = true;
            } else if (hasilCompare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!ditemukan) {
            System.out.println("NIM tidak ditemukan dalam daftar.");
        }
    }

    /**
     * Metode untuk melakukan pencarian data mahasiswa menggunakan sequential search
     * berdasarkan NIM.
     *
     * @param arr ArrayList yang berisi objek Mahasiswa.
     */
    static void sequentialSearch(ArrayList<Mahasiswa> arr) {

        inUs.nextLine();
        System.out.print("Masukkan NIM yang anda cari: ");
        String NIM = inUs.nextLine();

        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i).getNIM().equals(NIM)) {

                System.out.println("NIM berada pada indeks: " + i);
                return;
            }
        }
    }

    /**
     * Metode untuk menampilkan menu aplikasi.
     *
     * @return int Pilihan menu yang dipilih oleh pengguna.
     */
    static int menu() {

        System.out.println("\n1. Tambah data mahasiswa");
        System.out.println("2. Tampilkan data mahasiswa ");
        System.out.println("3. Hapus data mahasiswa ");
        System.out.println("4. Binary search ");
        System.out.println("5. Sequential search ");
        System.out.println("6. Interpolation search ");
        System.out.println("7. Keluar ");

        System.out.print("Pilih menu di atas ini (1-7): ");
        int pilihan = inUs.nextInt();

        return pilihan;
    }

    /**
     * Metode utama (entry point) dari aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {

        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();

        boolean lanjut = true;

        while (lanjut) {

            int pilihan = menu();

            switch (pilihan) {
                case 1:
                    tambahData(mahasiswa);
                    break;
                case 2:
                    tampilkanData(mahasiswa);
                    break;
                case 3:
                    hapusData(mahasiswa);
                    break;
                case 4:
                    binarySearch(mahasiswa);
                    break;
                case 5:
                    sequentialSearch(mahasiswa);
                    break;
                case 6:
                    interpolationSearch(mahasiswa);
                    break;
                case 7:
                    lanjut = false;
                    System.out.println("Terima Kasih telah menggunakan aplikasi kami");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan pilih menu lagi\n");
            }
        }
    }
}
