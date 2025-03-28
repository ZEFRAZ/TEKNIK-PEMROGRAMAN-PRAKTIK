import java.util.Scanner;

public class Facility {
    private Scanner scanner;
    private City city;

    public Facility(City city) {
        this.city = city;
        this.scanner = new Scanner(System.in);
    }

    public void buildFacility() {
        System.out.println("\n🏗️ Pilih fasilitas yang ingin dibangun:");
        System.out.println("1. Sekolah (Biaya: $100.000)");
        System.out.println("2. Rumah Sakit (Biaya: $150.000)");
        System.out.println("3. Taman Kota (Biaya: $50.000)");
        System.out.println("4. Polisi/Pemadam Kebakaran (Biaya: $200.000)");
        System.out.println("5. Kembali ke menu utama");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (city.getBudget() >= 100000) {
                    city.setBudget(city.getBudget() - 100000);
                    city.setEducation(city.getEducation() + 10);
                    city.setCrime(city.getCrime() - 5);
                    System.out.println("🏫 Sekolah berhasil dibangun! Pendidikan meningkat, kriminalitas menurun.");
                } else {
                    System.out.println("🚨 Anggaran tidak mencukupi untuk membangun sekolah.");
                }
                break;
            case 2:
                if (city.getBudget() >= 150000) {
                    city.setBudget(city.getBudget() - 150000);
                    city.setHealth(city.getHealth() + 10);
                    city.setHappiness(city.getHappiness() + 5);
                    System.out.println("🏥 Rumah sakit berhasil dibangun! Kesehatan dan kebahagiaan meningkat.");
                } else {
                    System.out.println("🚨 Anggaran tidak mencukupi untuk membangun rumah sakit.");
                }
                break;
            case 3:
                if (city.getBudget() >= 50000) {
                    city.setBudget(city.getBudget() - 50000);
                    city.setPollution(city.getPollution() - 10);
                    city.setHappiness(city.getHappiness() + 3);
                    System.out.println("🌳 Taman kota berhasil dibangun! Polusi berkurang, kebahagiaan meningkat.");
                } else {
                    System.out.println("🚨 Anggaran tidak mencukupi untuk membangun taman kota.");
                }
                break;
            case 4:
                if (city.getBudget() >= 200000) {
                    city.setBudget(city.getBudget() - 200000);
                    city.setCrime(city.getCrime() - 10);
                    System.out.println("🚓 Polisi/Pemadam Kebakaran berhasil ditambah! Kriminalitas menurun.");
                } else {
                    System.out.println("🚨 Anggaran tidak mencukupi untuk menambah polisi/pemadam kebakaran.");
                }
                break;
            case 5:
                System.out.println("Kembali ke menu utama.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}