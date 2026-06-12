//class pembayaran
public class Pembayaran {
    private String metodePembayaran;

    public Pembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getMetodePembayaran() {
        return this.metodePembayaran;
    }

    public void tampilkanPembayaran() {
        System.out.println("Metode Pembayaran : " + this.metodePembayaran);
        if (this.metodePembayaran.equalsIgnoreCase("QRIS")) {
            System.out.println("Silakan scan QRIS untuk melakukan pembayaran.");
        } else if (this.metodePembayaran.equalsIgnoreCase("Bank Transfer")) {
            System.out.println("Transfer ke Rekening:");
            System.out.println("Bank BSI : 7123456789");
            System.out.println("a.n Panitia Qurban");
        }
    }
}
