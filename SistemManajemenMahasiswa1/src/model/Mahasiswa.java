package model;

public class Mahasiswa extends Person {
    private String jurusan;

    public Mahasiswa(String id, String nama, int umur, String jurusan) {
        super(id, nama, umur);
        this.jurusan = jurusan;
    }

    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }

    @Override
    public void print() {
        System.out.println("[Mahasiswa] " + id + " - " + nama + ", Umur: " + umur + ", Jurusan: " + jurusan);
    }
}