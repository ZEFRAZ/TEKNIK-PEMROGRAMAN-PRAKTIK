import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarehouseManagement {
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static final Warehouse warehouse = new Warehouse();

    public static void main(String[] args) {
        warehouse.tambahBarangAwal();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 🏭 Sistem Manajemen Gudang ===");
            System.out.println("1️⃣ Lihat Stok Barang");
            System.out.println("2️⃣ Tambah Barang");
            System.out.println("3️⃣ Tambah Pesanan");
            System.out.println("4️⃣ Proses Semua Pesanan");
            System.out.println("5️⃣ Lihat Histori Pesanan");
            System.out.println("6️⃣ Keluar");
            System.out.print("🔷 Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> warehouse.tampilkanStok();
                case 2 -> {
                    System.out.print("🔹 Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.println("🔹 Kategori tersedia: " + warehouse.getKategoriBarang());
                    System.out.print("🔹 Masukkan kategori: ");
                    String kategori = scanner.nextLine();
                    System.out.print("🔹 Masukkan harga: ");
                    double harga = scanner.nextDouble();
                    System.out.print("🔹 Masukkan stok: ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();
                    warehouse.tambahBarang(nama, kategori, harga, stok);
                }
                case 3 -> {
                    System.out.print("🔹 Masukkan nama barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("🔹 Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    warehouse.tambahPesanan(namaBarang, jumlah);
                }
                case 4 -> executorService.submit(warehouse::prosesSemuaPesanan);
                case 5 -> warehouse.tampilkanHistori();
                case 6 -> {
                    System.out.println("✅ Terima kasih telah menggunakan sistem gudang!");
                    scanner.close();
                    executorService.shutdown();
                    return;
                }
                default -> System.out.println("⚠ Pilihan tidak valid.");
            }
        }
    }
}