public class Pemesanan {
    private Pelanggan pelanggan;
    private Tiket tiket;

    public Pemesanan(Pelanggan pelanggan, Tiket tiket) {
        this.pelanggan = pelanggan;
        this.tiket = tiket;
    }

    public void cetakStruk() {
        System.out.println("\n=== STRUK PEMESANAN TIKET ===");
        System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("Email          : " + pelanggan.getEmail());
        System.out.println("No. Telepon    : " + pelanggan.getNomorTelepon());
        System.out.println("Film           : " + tiket.getFilm().getJudul());
        System.out.println("Jumlah Tiket   : " + tiket.getJumlahTiket());
        System.out.println("Jadwal Tayang  : " + tiket.getFilm().getJadwalTayang());
        System.out.println("Total Harga    : Rp. " + tiket.getTotalHarga());
        System.out.println("=================================");
    }
}
