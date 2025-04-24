package service;

import model.Mahasiswa;
import generic.DataManager;

import java.util.Scanner;

public class MahasiswaService extends DataManager<Mahasiswa, String> {

    public void tambah(Scanner scanner) {
        System.out.println("Pilihan Jurusan:");
        util.ReferensiData.DAFTAR_JURUSAN.forEach(System.out::println);
    
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Umur: ");
        int umur = Integer.parseInt(scanner.nextLine());
        System.out.print("Jurusan: ");
        String jurusan = scanner.nextLine();
    
        tambah(id, new Mahasiswa(id, nama, umur, jurusan));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public void tampilkan() {
        semua().forEach(Mahasiswa::print);
    }

    public void cari(Scanner scanner) {
        System.out.print("Masukkan ID Mahasiswa: ");
        String id = scanner.nextLine();
        cari(id).ifPresentOrElse(
            Mahasiswa::print,
            () -> System.out.println("Mahasiswa tidak ditemukan.")
        );
    }

    public void update(Scanner scanner) {
        System.out.print("Masukkan ID Mahasiswa yang ingin diubah: ");
        String id = scanner.nextLine();
        cari(id).ifPresentOrElse(m -> {
            System.out.print("Nama baru: ");
            m.setNama(scanner.nextLine());
            System.out.print("Umur baru: ");
            m.setUmur(Integer.parseInt(scanner.nextLine()));
            System.out.print("Jurusan baru: ");
            m.setJurusan(scanner.nextLine());
            System.out.println("Data mahasiswa diperbarui.");
        }, () -> System.out.println("Mahasiswa tidak ditemukan."));
    }

    public void hapus(Scanner scanner) {
        System.out.print("Masukkan ID Mahasiswa yang ingin dihapus: ");
        String id = scanner.nextLine();
        if (ada(id)) {
            hapus(id);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
}