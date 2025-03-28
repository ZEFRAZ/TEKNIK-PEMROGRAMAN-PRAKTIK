public class Order {
    public void placeOrder(Restaurant restaurant, String namaMakanan, int jumlah) {
        MenuItem item = restaurant.getMenuItem(namaMakanan);
        
        if (item != null) {
            if (!item.isOutOfStock()) {
                item.kurangiStok(jumlah);
                System.out.println("Pesanan berhasil: " + jumlah + " " + namaMakanan);
            } else {
                System.out.println("Maaf, stok " + namaMakanan + " habis.");
            }
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }
}