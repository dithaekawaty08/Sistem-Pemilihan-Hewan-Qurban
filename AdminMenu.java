//class admin menu

import java.util.*;

public class AdminMenu {
    private static final String PASSWORD = "admin123";
    private static final long BATAS_HARGA = 2_000_000_000; 

    public static void tambahHewan(Map<Integer, List<HewanQurban>> daftarHewan, Scanner sc) {
        sc.nextLine(); 
        System.out.print("Masukkan password admin: ");
        String pass = sc.nextLine();
        if (!pass.equals(PASSWORD)) {
            System.out.println("Password salah!");
            return;
        }

        System.out.println("\n--- Tambah Hewan Qurban ---");
        System.out.println("Pilih kategori: ");
        System.out.println("1.Sapi "); 
        System.out.println("2.Kambing ");
        System.out.println("3.Domba ");
        System.out.println("4.Unta ");
        System.out.println("5.Kerbau");
        System.out.print("\nPilih nomor : ");
        int kategori = sc.nextInt();
        sc.nextLine();
        
        System.out.print(  "Jenis: ");
        String jenis = sc.nextLine();
        System.out.print(  "Berat (kg): ");
        double berat = sc.nextDouble();
        System.out.print(  "Harga: ");
        double harga = sc.nextDouble();
        sc.nextLine();
        System.out.print(  "Kode: ");
        String kodeBaru = sc.nextLine();
        
        if (harga>BATAS_HARGA) {
            System.out.println("Harga terlalu besar! Maksimal Rp 2.000.000.000");
            return;
        }
        HewanQurban hewanBaru = null;
        switch (kategori) {
            case 1: hewanBaru = new Sapi(kodeBaru, jenis, berat, harga); break;
            case 2: hewanBaru = new Kambing(kodeBaru, jenis, berat, harga); break;
            case 3: hewanBaru = new Domba(kodeBaru, jenis, berat, harga); break;
            case 4: hewanBaru = new Unta(kodeBaru, jenis, berat, harga); break;
            case 5: hewanBaru = new Kerbau(kodeBaru, jenis, berat, harga); break;
            default: System.out.println("Kategori tidak valid!"); return;
        }

        daftarHewan.get(kategori).add(hewanBaru);
        System.out.println("Hewan berhasil ditambahkan!");
    }
}
