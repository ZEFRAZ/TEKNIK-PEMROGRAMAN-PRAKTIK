package model;

import generic.Printable;

public record MataKuliah(String kode, String nama, int sks) implements Printable {
    @Override
    public void print() {
        System.out.println("[Mata Kuliah] " + kode + " - " + nama + ", SKS: " + sks);
    }
}