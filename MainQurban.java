//class main
import java.util.*;

public class MainQurban {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data Hewan per kategori
        Map<Integer, List<HewanQurban>> daftarHewan = new HashMap<>();

        // Sapi
        List<HewanQurban> sapiList = new ArrayList<>();
        sapiList.add(new Sapi("SB03", "Bali", 300, 30000000));
        sapiList.add(new Sapi("SB04", "Bali", 400, 80000000));
        sapiList.add(new Sapi("SB05", "Bali", 500, 100000000));
        sapiList.add(new Sapi("SS03", "Simental", 350, 35000000));
        sapiList.add(new Sapi("SS04", "Simental", 450, 90000000));
        daftarHewan.put(1, sapiList);

        // Kambing
        List<HewanQurban> kambingList = new ArrayList<>();
        kambingList.add(new Kambing("KE01", "Etawa", 30, 5000000));
        kambingList.add(new Kambing("KE02", "Etawa", 40, 6000000));
        kambingList.add(new Kambing("KK01", "Kacang", 25, 3000000));
        kambingList.add(new Kambing("KK02", "Kacang", 35, 4000000));
        daftarHewan.put(2, kambingList);

        // Domba
        List<HewanQurban> dombaList = new ArrayList<>();
        dombaList.add(new Domba("DG01", "Garut", 40, 7000000));
        dombaList.add(new Domba("DG02", "Garut", 50, 9000000));
        dombaList.add(new Domba("DM01", "Merino", 45, 8000000));
        daftarHewan.put(3, dombaList);

        // Unta
        List<HewanQurban> untaList = new ArrayList<>();
        untaList.add(new Unta("UA01", "Arab", 250, 25000000));
        untaList.add(new Unta("UA02", "Arab", 300, 30000000));
        daftarHewan.put(4, untaList);

        // Kerbau
        List<HewanQurban> kerbauList = new ArrayList<>();
        kerbauList.add(new Kerbau("KJ01", "Jawa", 300, 20000000));
        kerbauList.add(new Kerbau("KJ02", "Jawa", 400, 25000000));
        daftarHewan.put(5, kerbauList);

        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. List dan Daftar Harga Hewan");
            System.out.println("2. Pembelian Hewan Qurban");
            System.out.println("3. Keluar");
            System.out.println("4. Tambah Hewan Qurban (Admin Only)");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            try {
                switch (pilihan) {
                    case 1:
                        System.out.println("\n--- Pilih Hewan ---");
                        System.out.println("1. Sapi");
                        System.out.println("2. Kambing");
                        System.out.println("3. Domba");
                        System.out.println("4. Unta");
                        System.out.println("5. Kerbau");
                        System.out.print("Masukkan pilihan: ");
                        int pilihHewan = sc.nextInt();

                        List<HewanQurban> listDipilih = daftarHewan.get(pilihHewan);
                        if (listDipilih == null || listDipilih.isEmpty()) {
                            System.out.println("Stok kosong atau pilihan tidak valid!");
                        } else {
                            System.out.println("\n--- Daftar Jenis Hewan ---");
                            for (HewanQurban h : listDipilih) {
                                h.tampilkanHarga();
                            }
                        }
                        break;

                    case 2:
                        sc.nextLine(); // clear buffer
                        System.out.print("Nama Pembeli: ");
                        String nama = sc.nextLine();
                        System.out.print("No WA: ");
                        String noWa = sc.nextLine();
                        System.out.print("Domisili: ");
                        String domisili = sc.nextLine();
                        System.out.print("Masjid Terdekat: ");
                        String masjid = sc.nextLine();

                        System.out.println("\nMasukkan kode hewan yang ingin dibeli: ");
                        String kode = sc.nextLine();

                        HewanQurban hewanDipilih = null;
                        int kategoriDipilih = -1;
                        for (Map.Entry<Integer, List<HewanQurban>> entry : daftarHewan.entrySet()) {
                            for (HewanQurban h : entry.getValue()) {
                                if (h.getKode().equalsIgnoreCase(kode)) {
                                    hewanDipilih = h;
                                    kategoriDipilih = entry.getKey();
                                    break;
                                }
                            }
                        }

                        if (hewanDipilih == null) {
                            throw new Exception("Kode hewan tidak ditemukan!");
                        }

                        // Preview hewan
                        System.out.println("\n=== DETAIL HEWAN DIPILIH ===");
                        hewanDipilih.info();

                        // Metode pembayaran
                        System.out.println("\n=== METODE PEMBAYARAN ===");
                        System.out.println("1. QRIS");
                        System.out.println("2. Bank Transfer");
                        System.out.print("Pilih metode pembayaran: ");
                        int metode = sc.nextInt();

                        String metodeBayar = (metode == 1) ? "QRIS" : "Bank Transfer";
                        Pembayaran pembayaran = new Pembayaran(metodeBayar);

                        // Cetak struk
                        Pembelian pembelian = new Pembelian(nama, noWa, domisili, masjid, hewanDipilih);
                        pembelian.cetakStruk();

                        // Tampilkan detail pembayaran
                        pembayaran.tampilkanPembayaran();

                        // Hapus stok (hewan sudah dibeli)
                        StokManager.hapusStok(daftarHewan, hewanDipilih, kategoriDipilih);
                        break;

                    case 3:
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        break;

                    case 4:
                        AdminMenu.tambahHewan(daftarHewan, sc);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        } while (pilihan != 3);

        sc.close();
    }
}
