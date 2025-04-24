package service;

import model.Dosen;
import generic.DataManager;

import java.util.Scanner;

public class DosenService extends DataManager<Dosen, String> {

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Dosen ===");
            System.out.println("1. Tambah Dosen");
            System.out.println("2. Tampilkan Semua Dosen");
            System.out.println("3. Cari Dosen");
            System.out.println("4. Update Dosen");
            System.out.println("5. Hapus Dosen");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int pilih = Integer.parseInt(scanner.nextLine());

            switch (pilih) {
                case 1: tambah(scanner); break;
                case 2: tampilkan(); break;
                case 3: cari(scanner); break;
                case 4: update(scanner); break;
                case 5: hapus(scanner); break;
                case 0: return;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    public void tambah(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Umur: ");
        int umur = Integer.parseInt(scanner.nextLine());
        System.out.print("Departemen: ");
        String departemen = scanner.nextLine();
        tambah(id, new Dosen(id, nama, umur, departemen));
        System.out.println("Dosen berhasil ditambahkan.");
    }

    public void tampilkan() {
        semua().forEach(Dosen::print);
    }

    public void cari(Scanner scanner) {
        System.out.print("Masukkan ID Dosen: ");
        String id = scanner.nextLine();
        cari(id).ifPresentOrElse(
            Dosen::print,
            () -> System.out.println("Dosen tidak ditemukan."));
    }
    public void update(Scanner scanner) {
        System.out.print("Masukkan ID Dosen yang ingin diubah: ");
        String id = scanner.nextLine();
        cari(id).ifPresentOrElse(d -> {
            System.out.print("Nama baru: ");
            d.setNama(scanner.nextLine());
            System.out.print("Umur baru: ");
            d.setUmur(Integer.parseInt(scanner.nextLine()));
            System.out.print("Departemen baru: ");
            d.setDepartemen(scanner.nextLine());
            System.out.println("Data dosen diperbarui.");
        }, () -> System.out.println("Dosen tidak ditemukan."));
    }

    public void hapus(Scanner scanner) {
        System.out.print("Masukkan ID Dosen yang ingin dihapus: ");
        String id = scanner.nextLine();
        if (ada(id)) {
            hapus(id);
            System.out.println("Dosen berhasil dihapus.");
        } else {
            System.out.println("Dosen tidak ditemukan.");
        }
    }
}