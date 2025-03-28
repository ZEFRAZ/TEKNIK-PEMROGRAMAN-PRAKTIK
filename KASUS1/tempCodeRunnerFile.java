public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Bala-Bala", 1000, 20);
        menu.tambahMenuMakanan("Gehu", 1000, 20);
        menu.tambahMenuMakanan("Tahu", 1000, 0);
        menu.tambahMenuMakanan("Molen", 1000, 20);

        System.out.println("Menu Sebelum Pemesanan:");
        menu.tampilMenuMakanan();

        System.out.println("\n=== Pemesanan ===");
        menu.pesanMakanan("Bala-Bala", 5);
        menu.pesanMakanan("Gehu", 3);
        menu.pesanMakanan("Tahu", 1); // Harus gagal karena stok = 0
        menu.pesanMakanan("Molen", 1);

        System.out.println("\nMenu Setelah Pemesanan:");
        menu.tampilMenuMakanan();
    }
}