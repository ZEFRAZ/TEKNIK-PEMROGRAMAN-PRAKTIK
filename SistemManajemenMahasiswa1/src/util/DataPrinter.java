package util;

import generic.Printable;
import model.Mahasiswa;

import java.util.List;

public class DataPrinter {
    public static void printAll(List<? extends Printable> dataList) {
        for (Printable data : dataList) {
            data.print();
        }
    }

    public static void printAny(List<?> dataList) {
        for (Object obj : dataList) {
            System.out.println("Item: " + obj);
        }
    }

    public static void printSuperMahasiswa(List<? super Mahasiswa> dataList) {
        for (Object obj : dataList) {
            System.out.println("Objek disimpan (supertype Mahasiswa): " + obj);
        }
    }

    public static void simpanKeStorage(List<? super Mahasiswa> storage, List<Mahasiswa> daftarMhs) {
        for (Mahasiswa m : daftarMhs) {
            storage.add(m);
        }
        System.out.println("Data mahasiswa berhasil disalin ke penyimpanan umum.");
    }
}