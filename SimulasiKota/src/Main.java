import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int population = 100000 + random.nextInt(900000);
        double pollution = random.nextInt(100);
        double education = random.nextInt(100);
        double health = random.nextInt(100);
        double crime = random.nextInt(100);
        double happiness = random.nextInt(100);
        double budget = random.nextInt(5000000);

        City city = new City(population, pollution, education, health, crime, happiness, budget);
        Event event = new Event(city);
        Facility facility = new Facility(city);
        Simulation simulation = new Simulation(city, event, facility);

        simulation.startSimulation();
    }
}