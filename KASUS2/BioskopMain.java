import java.util.ArrayList;
import java.util.Scanner;

public class BioskopMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Film> daftarFilm = new ArrayList<>();

        // Menambahkan 10 film ke dalam daftar
        daftarFilm.add(new Film("Inception", "Sci-Fi", 148, "20:00", 50000));
        daftarFilm.add(new Film("Avengers: Endgame", "Action", 181, "18:30", 60000));
        daftarFilm.add(new Film("Interstellar", "Sci-Fi", 169, "21:00", 55000));
        daftarFilm.add(new Film("Joker", "Drama", 122, "19:00", 45000));
        daftarFilm.add(new Film("Frozen II", "Animation", 103, "17:00", 40000));
        daftarFilm.add(new Film("Parasite", "Thriller", 132, "20:30", 50000));
        daftarFilm.add(new Film("Spider-Man: No Way Home", "Action", 148, "22:00", 65000));
        daftarFilm.add(new Film("The Batman", "Crime", 176, "18:00", 60000));
        daftarFilm.add(new Film("Dune", "Sci-Fi", 155, "20:45", 55000));
        daftarFilm.add(new Film("Black Panther: Wakanda Forever", "Action", 161, "21:30", 60000));

        // Menampilkan daftar film
        System.out.println("=== DAFTAR FILM ===");
        for (int i = 0; i < daftarFilm.size(); i++) {
            daftarFilm.get(i).displayFilm(i + 1);
        }

        // Input data pelanggan
        System.out.print("\nMasukkan Nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Email Anda: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(nama, email, nomorTelepon);

        // Memilih film
        int pilihanFilm;
        do {
            System.out.print("\nPilih film (1-10): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka antara 1-10: ");
                scanner.next();
            }
            pilihanFilm = scanner.nextInt();
        } while (pilihanFilm < 1 || pilihanFilm > daftarFilm.size());

        Film filmTerpilih = daftarFilm.get(pilihanFilm - 1);

        // Memilih jumlah tiket
        int jumlahTiket;
        do {
            System.out.print("Masukkan jumlah tiket: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan jumlah tiket dalam angka: ");
                scanner.next();
            }
            jumlahTiket = scanner.nextInt();
        } while (jumlahTiket <= 0);

        // Membuat tiket dan pemesanan
        Tiket tiket = new Tiket(filmTerpilih, pelanggan, jumlahTiket);
        Pemesanan pemesanan = new Pemesanan(pelanggan, tiket);

        // Menampilkan struk pemesanan
        pemesanan.cetakStruk();

        scanner.close();
    }
}
