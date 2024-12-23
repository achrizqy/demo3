package main;

import java.util.Scanner;

public class HitungGaji {
    public static void main(String[] args) {
        // Gaji per hari
        int gajiPerHari = 100000;
        int totalHariDalamBulan = 30;

        // Membuat scanner untuk input
        Scanner scanner = new Scanner(System.in);

        // Meminta input jumlah hari kerja
        int hariKerja;
        do {
            System.out.print("Masukkan jumlah hari pekerja masuk kerja (maks 30 hari): ");
            hariKerja = scanner.nextInt();
            if (hariKerja < 1 || hariKerja > totalHariDalamBulan) {
                System.out.println("Jumlah hari kerja harus antara 1-30 hari.");
            }
        } while (hariKerja < 1 || hariKerja > totalHariDalamBulan);

        // Meminta input jumlah hari izin
        int hariIzin;
        do {
            System.out.print("Masukkan jumlah hari izin (maks " + (totalHariDalamBulan - hariKerja) + " hari): ");
            hariIzin = scanner.nextInt();
            if (hariIzin < 0 || hariIzin > (totalHariDalamBulan - hariKerja)) {
                System.out.println("Jumlah hari izin tidak valid. Harus antara 0 dan " + (totalHariDalamBulan - hariKerja) + " hari.");
            }
        } while (hariIzin < 0 || hariIzin > (totalHariDalamBulan - hariKerja));

        // Menghitung jumlah hari absen
        int hariAbsen = totalHariDalamBulan - (hariKerja + hariIzin);

        // Menghitung total gaji
        int gajiTotal = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHariDalamBulan);

        // Menampilkan hasil
        System.out.println("Jumlah hari kerja: " + hariKerja);
        System.out.println("Jumlah hari izin: " + hariIzin);
        System.out.println("Jumlah hari absen: " + hariAbsen);
        System.out.println("Gaji total selama sebulan adalah: Rp " + gajiTotal);

        // Menutup scanner
        scanner.close();
    }

    // Fungsi untuk menghitung gaji
    public static int hitungGaji(int hariKerja, int hariIzin, int gajiPerHari, int totalHari) {
        // Hitung gaji total berdasarkan hari kerja
        int gajiTotal = hariKerja * gajiPerHari;

        // Menambahkan gaji berdasarkan hari izin
        double presentaseBonus = (double) hariIzin / totalHari;
        gajiTotal += gajiTotal * presentaseBonus;

        // Pastikan gaji tidak negatif
        return (gajiTotal < 0) ? 0 : (int) gajiTotal;
    }
}