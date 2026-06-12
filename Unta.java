//class Unta

public class Unta extends HewanQurban {
    private String kategori;

    public Unta(String kode, String kategori, double berat, double harga) {
        super(kode, "Unta " + kategori, berat, harga);
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
