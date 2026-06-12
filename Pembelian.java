//class pembelian
import java.text.NumberFormat;
import java.util.Locale;

public class Pembelian {
    private String nama;
    private String noWa;
    private String domisili;
    private String masjid;
    private HewanQurban hewan;

    // Constructor dengan 5 parameter
    public Pembelian(String nama, String noWa, String domisili, String masjid, HewanQurban hewan) {
        this.nama = nama;
        this.noWa = noWa;
        this.domisili = domisili;
        this.masjid = masjid;
        this.hewan = hewan;
    }

    public void cetakStruk() {
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));
        System.out.println("\n===== STRUK PEMBELIAN =====");
        System.out.println("Nama Pembeli   : " + nama);
        System.out.println("No WA          : " + noWa);
        System.out.println("Domisili       : " + domisili);
        System.out.println("Masjid Terdekat: " + masjid);
        System.out.println("Hewan Qurban   : " + hewan.jenis + " (" + hewan.berat + " kg)");
        System.out.println("Kode Hewan     : " + hewan.getKode());
        System.out.println("Harga          : Rp " + nf.format(hewan.getHarga()));
        System.out.println("============================");
    }
}
