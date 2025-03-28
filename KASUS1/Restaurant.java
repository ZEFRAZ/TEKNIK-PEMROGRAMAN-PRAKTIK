import java.util.ArrayList;

public class Restaurant {
    private ArrayList<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    public void addMenuItem(String nama, double harga, int stok) {
        menu.add(new MenuItem(nama, harga, stok));
    }

    public void displayMenu() {
        System.out.println("\nDaftar Menu:");
        for (MenuItem item : menu) {
            if (!item.isOutOfStock()) {
                System.out.println(item.getNama() + " [" + item.getStok() + "] \tRp. " + item.getHarga());
            }
        }
    }

    public MenuItem getMenuItem(String nama) {
        for (MenuItem item : menu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        return null; // Jika makanan tidak ditemukan
    }
}
