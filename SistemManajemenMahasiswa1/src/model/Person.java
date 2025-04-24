package model;

import generic.Printable;

public abstract class Person implements Printable {
    protected String id;
    protected String nama;
    protected int umur;

    public Person(String id, String nama, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    public String getId() { 
        return id; }
    public String getNama() { 
        return nama; }
    public int getUmur() { 
        return umur; }

    public void setNama(String nama) { this.nama = nama; }
    public void setUmur(int umur) { this.umur = umur; }
}