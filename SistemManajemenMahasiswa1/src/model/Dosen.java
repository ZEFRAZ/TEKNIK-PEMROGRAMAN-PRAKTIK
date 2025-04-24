package model;

public class Dosen extends Person {
    private String departemen;

    public Dosen(String id, String nama, int umur, String departemen) {
        super(id, nama, umur);
        this.departemen = departemen;
    }

    public String getDepartemen() { return departemen; }
    public void setDepartemen(String departemen) { this.departemen = departemen; }

    @Override
    public void print() {
        System.out.println("[Dosen] " + id + " - " + nama + ", Umur: " + umur + ", Departemen: " + departemen);
    }
}