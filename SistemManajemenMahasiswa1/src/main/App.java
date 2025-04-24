package main;

import service.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MahasiswaService mhsService = new MahasiswaService();
        DosenService dosenService = new DosenService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Semua Mahasiswa");
            System.out.println("3. Cari Mahasiswa");
            System.out.println("4. Update Mahasiswa");
            System.out.println("5. Hapus Mahasiswa");
            System.out.println("6. Menu Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = scanner.nextInt(); scanner.nextLine();

            switch (pilih) {
                case 1: mhsService.tambah(scanner); break;
                case 2: mhsService.tampilkan(); break;
                case 3: mhsService.cari(scanner); break;
                case 4: mhsService.update(scanner); break;
                case 5: mhsService.hapus(scanner); break;
                case 6: dosenService.menu(scanner); break;
                case 0: return;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }
}