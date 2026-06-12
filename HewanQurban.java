//class HewanQurban
import java.text.NumberFormat;
import java.util.Locale;

public abstract class HewanQurban implements Harga {
    protected String kode;
    protected String jenis;
    protected double harga;
    protected double berat;

    public HewanQurban(String kode, String jenis, double berat, double harga) {
        this.kode = kode;
        this.jenis = jenis;
        this.berat = berat;
        this.harga = harga;
    }

    public abstract void info();

    public String getKode() {
        return kode;
    }

    public double getHarga() {
        return harga;
    }

    public String formatHarga() {
        NumberFormat nf = NumberFormat.getInstance(new Locale("id", "ID"));
        return nf.format(harga);
    }
}
