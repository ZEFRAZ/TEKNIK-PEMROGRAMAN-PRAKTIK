import java.util.Random;
import java.util.Scanner;

public class Event {
    private Random random;
    private Scanner scanner;
    private City city;

    public Event(City city) {
        this.city = city;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void dailyEvent() {
        int event = random.nextInt(100);
        if (event < 5) {
            System.out.println("\n🌪️ [Bencana Alam Terjadi!]");
            handleDisaster();
        } else if (event < 15) {
            System.out.println("\n🎉 [Festival Kota!]");
            handleFestival();
        } else if (event < 30) {
            System.out.println("\n☁️ [Polusi Meningkat!]");
            handlePollution();
        } else if (event < 35) {
            System.out.println("\n🚀 [Bonus Ekonomi & Penemuan Teknologi!]");
            handleEconomicBonus();
        } else {
            System.out.println("\n🌞 [Hari ini tidak ada peristiwa khusus.]");
        }
    }

    private void handleDisaster() {
        System.out.println("Apakah ingin mengirim pemadam kebakaran? (y/t)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            if (city.getBudget() >= 50000) {
                city.setBudget(city.getBudget() - 50000);
                System.out.println("🔥 Kebakaran berhasil dikendalikan.");
                city.setPopulation(Math.max(100000, city.getPopulation() - 1000));
                city.setHappiness(Math.max(0, city.getHappiness() - 2));
            } else {
                System.out.println("🚨 Anggaran tidak mencukupi.");
                city.setPopulation(Math.max(100000, city.getPopulation() - 5000));
                city.setEducation(Math.max(0, city.getEducation() - 3));
                city.setHappiness(Math.max(0, city.getHappiness() - 4));
                city.setCrime(Math.min(100, city.getCrime() + 3));
            }
        } else {
            city.setPopulation(Math.max(100000, city.getPopulation() - 5000));
            city.setEducation(Math.max(0, city.getEducation() - 3));
            city.setHappiness(Math.max(0, city.getHappiness() - 4));
            city.setCrime(Math.min(100, city.getCrime() + 3));
        }
    }

    private void handleFestival() {
        System.out.println("Apakah ingin mengadakan festival? (y/t)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            if (city.getBudget() >= 30000) {
                city.setBudget(city.getBudget() - 30000);
                city.setHappiness(Math.min(100, city.getHappiness() + 10));
                System.out.println("🎊 Festival berhasil diadakan! Kebahagiaan meningkat.");
            } else {
                System.out.println("🚨 Anggaran tidak mencukupi untuk mengadakan festival.");
            }
        } else {
            System.out.println("🎭 Tidak ada festival diadakan.");
        }
    }

    private void handlePollution() {
        System.out.println("Apakah ingin membersihkan polusi? (y/t)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            if (city.getBudget() >= 40000) {
                city.setBudget(city.getBudget() - 40000);
                city.setPollution(Math.max(0, city.getPollution() - 10));
                city.setHealth(Math.min(100, city.getHealth() + 5));
                System.out.println("🌿 Polusi berhasil dikurangi. Kesehatan meningkat.");
            } else {
                System.out.println("🚨 Anggaran tidak mencukupi untuk membersihkan polusi.");
                city.setPollution(Math.min(100, city.getPollution() + 5));
                city.setHealth(Math.max(0, city.getHealth() - 3));
            }
        } else {
            city.setPollution(Math.min(100, city.getPollution() + 5));
            city.setHealth(Math.max(0, city.getHealth() - 3));
            System.out.println("☁️ Polusi meningkat, kesehatan menurun.");
        }
    }

    private void handleEconomicBonus() {
        System.out.println("Apakah ingin menginvestasikan bonus ekonomi ke pendidikan? (y/t)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            city.setEducation(Math.min(100, city.getEducation() + 10));
            System.out.println("📚 Investasi berhasil! Pendidikan meningkat.");
        } else {
            city.setBudget(Math.min(5000000, city.getBudget() + 100000));
            System.out.println("💰 Bonus ekonomi diterima, tetapi tidak diinvestasikan ke pendidikan.");
        }
    }
}