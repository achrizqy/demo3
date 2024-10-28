import java.util.Scanner;

public class HitungGaji {
    /**
     * Menampilkan gaji total berdasarkan input jumlah hari kerja.
     *
     * <p>Gaji per hari dianggap sebagai 200000 dan total hari dalam bulan
     * dianggap sebagai 30. Jika input jumlah hari kerja kurang dari 1 atau
     * melebihi total hari dalam bulan, maka program akan meminta input
     * ulang.</p>
     *
     * <p>Hasil gaji total akan ditampilkan dalam satuan rupiah.</p>
     *
     * @param args tidak digunakan
     */
    public static void main(String[] args) {
        // Gaji per hari
        int gajiPerHari = 200000;
        int totalHariDalamBulan = 30;

        // Membuat scanner untuk input
        Scanner scanner = new Scanner(System.in);

        // Meminta input jumlah hari kerja
        int hariKerja;
        do {
            System.out.print("Masukkan jumlah hari pekerja masuk kerja (maks 30 hari): ");
            hariKerja = scanner.nextInt();
        } while (hariKerja < 1 || hariKerja > totalHariDalamBulan);

        // Menampilkan hasil
        int gajiTotal = hitungGaji(hariKerja, gajiPerHari);
        System.out.println("Gaji total selama sebulan adalah: Rp " + gajiTotal);

        // Menutup scanner
        scanner.close();
    }

    // Fungsi untuk menghitung gaji
    public static int hitungGaji(int hariKerja, int gajiPerHari) {
        int gajiMaks = 5600000;
        int gajiTotal = hariKerja * gajiPerHari;
        return (gajiTotal > gajiMaks) ? gajiMaks : gajiTotal;
    }
}