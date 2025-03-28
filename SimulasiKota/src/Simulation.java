import java.util.Scanner;

public class Simulation {
    private City city;
    private Event event;
    private Facility facility;
    private int days;

    public Simulation(City city, Event event, Facility facility) {
        this.city = city;
        this.event = event;
        this.facility = facility;
    }

    public void simulateDay(int day) {
        city.addDailyIncome();
        event.dailyEvent();
        city.updatePollutionEffects();
        city.dailyReport(day);
    }

    public void startSimulation() {
        System.out.println("🌟 Selamat datang di Simulasi Kota! 🌟");
        System.out.println("Status Awal Kota:");
        city.dailyReport(0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah hari untuk simulasi:");
        days = scanner.nextInt();

        for (int i = 1; i <= days; i++) {
            simulateDay(i);
            System.out.println("\n🏗️ Apakah ingin membangun fasilitas? (y/t)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")) {
                facility.buildFacility();
            }
        }

        System.out.println("🏁 Simulasi selesai. Apakah ingin melakukan simulasi ulang? (y/t)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            city = new City(100000 + (int) (Math.random() * 900000), Math.random() * 100, Math.random() * 100, Math.random() * 100, Math.random() * 100, Math.random() * 100, Math.random() * 5000000);
            event = new Event(city);
            facility = new Facility(city);
            startSimulation();
        } else {
            System.out.println("🙏 Terima kasih telah bermain!");
        }
    }
}