import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan menu
        menu.addMenuItem("Bala-Bala", 1_000, 20);
        menu.addMenuItem("Gehu", 1_000, 20);
        menu.addMenuItem("Tahu", 1_000, 0); 
        menu.addMenuItem("Molen", 1_000, 20);

        while (true) {
            menu.displayMenu();

            System.out.print("\nPesan makanan (ketik nama): ");
            String namaMakanan = scanner.nextLine();

            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Menghindari bug newline

            order.placeOrder(menu, namaMakanan, jumlah);

            System.out.print("Pesan lagi? (y/t): ");
            String ulang = scanner.nextLine();
            if (!ulang.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("\nTerima kasih telah memesan!");
        scanner.close();
    }
}
