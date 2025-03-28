import java.util.logging.Logger;

public class Buku {
    private static final Logger LOGGER = Logger.getLogger(Buku.class.getName());
    private final String judul;
    private boolean dipinjam;

    public Buku(String judul) {
        this.judul = judul;
        this.dipinjam = false;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isDipinjam() {
        return dipinjam;
    }

    public void pinjam() {
        dipinjam = true;
        LOGGER.info("Buku '" + judul + "' telah dipinjam.");
    }

    public void kembalikan() {
        dipinjam = false;
        LOGGER.info("Buku '" + judul + "' telah dikembalikan.");
    }

    public void tampilkanStatus() {
        System.out.printf("%s | Status: %s%n", judul, dipinjam ? "Dipinjam" : "Tersedia");
    }
}
