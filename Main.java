import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Tampilkan Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Filter Buku (Tersedia/Dipinjam)");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                LOGGER.warning("Input bukan angka pada menu utama.");
                continue;
            }
            
            switch (pilihan) {
                case 1:
                    perpustakaan.tampilkanDaftarBuku();
                    break;
                case 2:
                    perpustakaan.tampilkanDaftarBuku();
                    System.out.print("Pilih nomor buku yang ingin dipinjam: ");
                    try {
                        int indeks = Integer.parseInt(scanner.nextLine()) - 1;
                        perpustakaan.pinjamBuku(indeks);
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid!");
                        LOGGER.warning("Input tidak valid pada peminjaman buku.");
                    }
                    break;
                case 3:
                    perpustakaan.tampilkanDaftarBuku();
                    System.out.print("Pilih nomor buku yang ingin dikembalikan: ");
                    try {
                        int indeks = Integer.parseInt(scanner.nextLine()) - 1;
                        perpustakaan.kembalikanBuku(indeks);
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid!");
                        LOGGER.warning("Input tidak valid pada pengembalian buku.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String kataKunci = scanner.nextLine();
                    List<Buku> hasilCari = perpustakaan.cariBuku(kataKunci);
                    if (hasilCari.isEmpty()) {
                        System.out.println("Tidak ada buku yang cocok.");
                    } else {
                        System.out.println("\nHasil Pencarian:");
                        for (Buku b : hasilCari) {
                            b.tampilkanStatus();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Filter (1: Tersedia, 2: Dipinjam): ");
                    String statusInput = scanner.nextLine();
                    boolean statusFilter;
                    if ("1".equals(statusInput)) {
                        statusFilter = false; // Buku tersedia
                    } else if ("2".equals(statusInput)) {
                        statusFilter = true; // Buku dipinjam
                    } else {
                        System.out.println("Input tidak valid!");
                        break;
                    }
                    List<Buku> hasilFilter = perpustakaan.filterBukuByStatus(statusFilter);
                    if (hasilFilter.isEmpty()) {
                        System.out.println("Tidak ada buku yang sesuai dengan filter.");
                    } else {
                        System.out.println("\nHasil Filter:");
                        for (Buku b : hasilFilter) {
                            b.tampilkanStatus();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Terima kasih, Selamat Membaca!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
        scanner.close();
    }
}
