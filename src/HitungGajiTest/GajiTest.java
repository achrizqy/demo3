package HitungGajiTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GajiTest {

    @Test
    public void testGajiTanpaIzin() {
        int hariKerja = 20;
        int hariIzin = 0;
        int gajiPerHari = 100000;
        int totalHari = 30;

        int hasil = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHari);
        assertEquals(2000000, hasil);
    }

    @Test
    public void testGajiDenganIzin() {
        int hariKerja = 20;
        int hariIzin = 5;
        int gajiPerHari = 100000;
        int totalHari = 30;

        int hasil = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHari);
        assertEquals(1666666, hasil); // 2000000 - (2000000 * (5/30))
    }

    @Test
    public void testGajiDenganIzinMenyeluruh() {
        int hariKerja = 0;
        int hariIzin = 30;
        int gajiPerHari = 100000;
        int totalHari = 30;

        int hasil = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHari);
        assertEquals(0, hasil); // Semua hari izin
    }

    @Test
    public void testGajiNegatif() {
        int hariKerja = 10;
        int hariIzin = 20; // Lebih banyak izin daripada kerja
        int gajiPerHari = 100000;
        int totalHari = 30;

        int hasil = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHari);
        assertEquals(333333, hasil); // 1000000 - (1000000 * (20/30))
    }

    @Test
    public void testGajiDenganSatuHariKerja() {
        int hariKerja = 1;
        int hariIzin = 1; // Satu izin
        int gajiPerHari = 100000;
        int totalHari = 30;

        int hasil = hitungGaji(hariKerja, hariIzin, gajiPerHari, totalHari);
    }

    // Metode yang diuji
    public static int hitungGaji(int hariKerja, int hariIzin, int gajiPerHari, int totalHari) {
        // Hitung gaji total berdasarkan hari kerja
        int gajiTotal = hariKerja * gajiPerHari;

        // Mengurangi gaji berdasarkan hari izin
        double presentasePengurangan = (double) hariIzin / totalHari;
        gajiTotal -= gajiTotal * presentasePengurangan;

        // Pastikan gaji tidak negatif
        return (gajiTotal < 0) ? 0 : (int) gajiTotal;
    }
}