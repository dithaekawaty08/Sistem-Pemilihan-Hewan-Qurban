//class Kambing
public class Kambing extends HewanQurban {
    private String kategori;

    public Kambing(String kode, String kategori, double berat, double harga) {
        super(kode, "Kambing " + kategori, berat, harga);
        this.kategori = kategori;
    }

    @Override
    public void info() {
        System.out.println(jenis + " (" + berat + " kg) - Rp " + formatHarga() + " [Kode: " + kode + "]");
    }

    @Override
    public void tampilkanHarga() {
        info();
    }
}
