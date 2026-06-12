//class Sapi
public class Sapi extends HewanQurban {
    private String kategori;

    public Sapi(String kode, String kategori, double berat, double harga) {
        super(kode, "Sapi " + kategori, berat, harga);
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
