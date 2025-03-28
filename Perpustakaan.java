import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    private final List<Buku> daftarBuku = new ArrayList<>();

    /**
     * Konstruktor: Memuat data buku awal.
     */
    public Perpustakaan() {
        daftarBuku.add(new Buku("Laskar Pelangi"));
        daftarBuku.add(new Buku("Bumi Manusia"));
        daftarBuku.add(new Buku("Negeri 5 Menara"));
        daftarBuku.add(new Buku("Laut Bercerita"));
        daftarBuku.add(new Buku("Perahu Kertas"));
        daftarBuku.add(new Buku("1984"));
        daftarBuku.add(new Buku("BABEL"));
        daftarBuku.add(new Buku("Animal Farm"));
    }

    /**
     * Menampilkan daftar buku beserta statusnya.
     */
    public void tampilkanDaftarBuku() {
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarBuku.get(i).tampilkanStatus();
        }
    }

    /**
     * Memproses peminjaman buku berdasarkan indeks.
     */
    public void pinjamBuku(int indeks) {
        if (indeks >= 0 && indeks < daftarBuku.size()) {
            Buku buku = daftarBuku.get(indeks);
            if (!buku.isDipinjam()) {
                buku.pinjam();
                System.out.println("Buku berhasil dipinjam!");
            } else {
                System.out.println("Buku sudah dipinjam!");
            }
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }
    
    /**
     * Memproses pengembalian buku berdasarkan indeks.
     */
    public void kembalikanBuku(int indeks) {
        if (indeks >= 0 && indeks < daftarBuku.size()) {
            Buku buku = daftarBuku.get(indeks);
            if (buku.isDipinjam()) {
                buku.kembalikan();
                System.out.println("Buku berhasil dikembalikan!");
            } else {
                System.out.println("Buku ini belum dipinjam!");
            }
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    /**
     * Mencari buku berdasarkan kata kunci pada judul.
     */
    public List<Buku> cariBuku(String kataKunci) {
        List<Buku> hasil = new ArrayList<>();
        for (Buku b : daftarBuku) {
            if (b.getJudul().toLowerCase().contains(kataKunci.toLowerCase())) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    /**
     * Memfilter buku berdasarkan status (tersedia atau dipinjam).
     */
    public List<Buku> filterBukuByStatus(boolean dipinjam) {
        List<Buku> hasil = new ArrayList<>();
        for (Buku b : daftarBuku) {
            if (b.isDipinjam() == dipinjam) {
                hasil.add(b);
            }
        }
        return hasil;
    }
}
