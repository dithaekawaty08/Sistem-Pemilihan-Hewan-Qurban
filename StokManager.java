//class stok manager
import java.util.*;

public class StokManager {
    public static void hapusStok(Map<Integer, List<HewanQurban>> daftarHewan, HewanQurban hewan, int kategori) {
        daftarHewan.get(kategori).remove(hewan);
        System.out.println("Stok hewan dengan kode " + hewan.getKode() + " sudah terjual dan dihapus dari daftar.");
    }
}
