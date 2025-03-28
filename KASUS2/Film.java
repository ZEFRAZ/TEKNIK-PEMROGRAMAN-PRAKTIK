public class Film {
    private String judul;
    private String genre;
    private int durasi; // dalam menit
    private String jadwalTayang;
    private double hargaTiket;

    public Film(String judul, String genre, int durasi, String jadwalTayang, double hargaTiket) {
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.jadwalTayang = jadwalTayang;
        this.hargaTiket = hargaTiket;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getJadwalTayang() {
        return jadwalTayang;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    public void displayFilm(int nomor) {
        System.out.println(nomor + ". " + judul + " (" + genre + ") - " + durasi + " menit, " + jadwalTayang + " - Rp. " + hargaTiket);
    }
}
