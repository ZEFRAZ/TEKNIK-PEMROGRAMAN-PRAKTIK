import java.util.Objects;

public class Pesanan {
    private final String namaBarang;
    private final int jumlah;

    public Pesanan(String namaBarang, int jumlah) {
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
    }

    public String getNamaBarang() { return namaBarang; }
    public int getJumlah() { return jumlah; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pesanan pesanan = (Pesanan) o;
        return jumlah == pesanan.jumlah &&
                Objects.equals(namaBarang, pesanan.namaBarang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namaBarang, jumlah);
    }
}