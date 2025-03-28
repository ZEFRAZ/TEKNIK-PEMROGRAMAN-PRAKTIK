import java.util.*;
import java.util.concurrent.*;

public class Warehouse {
    private final Map<String, StokBarang> stokBarang = new ConcurrentHashMap<>();
    private final Queue<Pesanan> antreanFIFO = new LinkedList<>();
    private final PriorityQueue<Pesanan> antreanPrioritas =
            new PriorityQueue<>(Comparator.comparingInt(p -> - (int) stokBarang.get(p.getNamaBarang()).barang().harga()));
    private final Deque<Pesanan> antreanLIFO = new ArrayDeque<>();
    private final List<Pesanan> historiPesanan = new ArrayList<>();
    private final Set<String> kategoriBarang = Set.of("Elektronik", "Makanan", "Pakaian");

    // Metode baru untuk mengembalikan kategori barang
    public Set<String> getKategoriBarang() {
        return kategoriBarang;
    }

    // Metode-metode lainnya tetap sama...
    public void tambahBarangAwal() {
        stokBarang.put("Laptop", new StokBarang(new Barang("Laptop", "Elektronik", 15000000), 10));
        stokBarang.put("Baju", new StokBarang(new Barang("Baju", "Pakaian", 200000), 20));
        stokBarang.put("Roti", new StokBarang(new Barang("Roti", "Makanan", 15000), 50));
    }

    public void tambahBarang(String nama, String kategori, double harga, int stok) {
        if (!kategoriBarang.contains(kategori)) {
            System.out.println("⚠ Kategori tidak valid!");
            return;
        }
        stokBarang.put(nama, new StokBarang(new Barang(nama, kategori, harga), stok));
        System.out.println("✅ Barang berhasil ditambahkan!");
    }

    public void tambahPesanan(String nama, int jumlah) {
        Optional<StokBarang> optionalStok = Optional.ofNullable(stokBarang.get(nama));
        optionalStok.ifPresentOrElse(
                stok -> {
                    if (stok.stok() >= jumlah) {
                        Pesanan pesanan = new Pesanan(nama, jumlah);
                        String kategori = stok.barang().kategori();
                        if (kategori.equals("Elektronik") && stok.barang().harga() > 500000) {
                            antreanPrioritas.add(pesanan);
                        } else if (kategori.equals("Pakaian")) {
                            antreanLIFO.addFirst(pesanan);
                        } else {
                            antreanFIFO.add(pesanan);
                        }
                        System.out.println("✅ Pesanan ditambahkan ke antrean!");
                    } else {
                        System.out.println("⚠ Stok tidak mencukupi!");
                    }
                },
                () -> System.out.println("⚠ Barang tidak ditemukan!")
        );
    }

    public void prosesSemuaPesanan() {
        System.out.println("\n=== 🔄 Memproses Semua Pesanan ===");
        tampilkanDaftarPesanan();
        prosesPesanan(antreanPrioritas, "PRIORITAS");
        prosesPesanan(antreanFIFO, "FIFO");
        prosesPesanan(antreanLIFO, "LIFO");
    }

    private void prosesPesanan(Queue<Pesanan> queue, String metode) {
        Iterator<Pesanan> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Pesanan pesanan = iterator.next();
            if (stokBarang.containsKey(pesanan.getNamaBarang())) {
                StokBarang stokSaatIni = stokBarang.get(pesanan.getNamaBarang());
                int stokBaru = stokSaatIni.stok() - pesanan.getJumlah();

                if (stokBaru >= 0) {
                    stokBarang.put(pesanan.getNamaBarang(), new StokBarang(stokSaatIni.barang(), stokBaru));
                    historiPesanan.add(pesanan);
                    System.out.printf("✅ Pesanan %s sebanyak %d diproses dengan metode %s! Sisa stok: %d\n",
                            pesanan.getNamaBarang(), pesanan.getJumlah(), metode, stokBaru);
                    hapusPesananDariSemuaAntrean(pesanan);
                    iterator.remove();
                } else {
                    System.out.printf("⚠ Stok %s tidak mencukupi untuk diproses dengan metode %s!\n",
                            pesanan.getNamaBarang(), metode);
                }
            }
        }
    }

    private void hapusPesananDariSemuaAntrean(Pesanan pesanan) {
        antreanFIFO.remove(pesanan);
        antreanPrioritas.remove(pesanan);
        antreanLIFO.remove(pesanan);
    }

    public void tampilkanStok() {
        System.out.println("\n=== 📦 Stok Barang ===");
        Map<String, List<StokBarang>> barangPerKategori = new TreeMap<>();
        for (StokBarang stok : stokBarang.values()) {
            String kategori = stok.barang().kategori();
            barangPerKategori.computeIfAbsent(kategori, k -> new ArrayList<>()).add(stok);
        }

        for (Map.Entry<String, List<StokBarang>> entry : barangPerKategori.entrySet()) {
            String kategori = entry.getKey();
            List<StokBarang> barang = entry.getValue();
            barang.sort(Comparator.comparing(s -> s.barang().nama()));
            System.out.println("\n🔹 Kategori: " + kategori);
            for (StokBarang stok : barang) {
                System.out.printf("   🔸 %s - Stok: %d | Harga: Rp%.2f\n",
                        stok.barang().nama(), stok.stok(), stok.barang().harga());
            }
        }
    }

    public void tampilkanDaftarPesanan() {
        System.out.println("\n=== 📋 Daftar Pesanan ===");
        System.out.println("🔹 Pesanan PRIORITAS:");
        antreanPrioritas.forEach(p -> System.out.printf("   🔸 %s - Jumlah: %d\n", p.getNamaBarang(), p.getJumlah()));
        System.out.println("\n🔹 Pesanan FIFO:");
        antreanFIFO.forEach(p -> System.out.printf("   🔸 %s - Jumlah: %d\n", p.getNamaBarang(), p.getJumlah()));
        System.out.println("\n🔹 Pesanan LIFO:");
        antreanLIFO.forEach(p -> System.out.printf("   🔸 %s - Jumlah: %d\n", p.getNamaBarang(), p.getJumlah()));
    }

    public void tampilkanHistori() {
        System.out.println("\n=== 📝 Histori Pesanan ===");
        if (historiPesanan.isEmpty()) {
            System.out.println("⚠ Belum ada pesanan yang diproses.");
        } else {
            historiPesanan.forEach(p -> System.out.printf("🔹 %s - Jumlah: %d\n", p.getNamaBarang(), p.getJumlah()));
        }
    }
}