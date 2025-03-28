public class Tiket {
    private Film film;
    private Pelanggan pelanggan;
    private int jumlahTiket;
    private double totalHarga;

    public Tiket(Film film, Pelanggan pelanggan, int jumlahTiket) {
        this.film = film;
        this.pelanggan = pelanggan;
        this.jumlahTiket = jumlahTiket;
        this.totalHarga = hitungTotalHarga();
    }

    public double hitungTotalHarga() {
        return jumlahTiket * film.getHargaTiket();
    }

    public Film getFilm() {
        return film;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}
