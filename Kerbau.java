//class Kerbau
public class Kerbau extends HewanQurban {
    private String kategori;

    public Kerbau(String kode, String kategori, double berat, double harga) {
        super(kode, "Kerbau " + kategori, berat, harga);
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
