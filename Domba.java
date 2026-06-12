//class Domba

public class Domba extends HewanQurban {
    private String kategori;

    public Domba(String kode, String kategori, double berat, double harga) {
        super(kode, "Domba " + kategori, berat, harga);
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
