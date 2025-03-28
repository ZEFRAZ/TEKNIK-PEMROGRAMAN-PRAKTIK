public class City {
    private int population;
    private double pollution;
    private double education;
    private double health;
    private double crime;
    private double happiness;
    private double budget;

    private int prevPopulation;
    private double prevPollution;
    private double prevEducation;
    private double prevHealth;
    private double prevCrime;
    private double prevHappiness;
    private double prevBudget;

    public City(int population, double pollution, double education, double health, double crime, double happiness, double budget) {
        this.population = population;
        this.pollution = pollution;
        this.education = education;
        this.health = health;
        this.crime = crime;
        this.happiness = happiness;
        this.budget = budget;

        this.prevPopulation = population;
        this.prevPollution = pollution;
        this.prevEducation = education;
        this.prevHealth = health;
        this.prevCrime = crime;
        this.prevHappiness = happiness;
        this.prevBudget = budget;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        this.pollution = pollution;
    }

    public double getEducation() {
        return education;
    }

    public void setEducation(double education) {
        this.education = education;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getCrime() {
        return crime;
    }

    public void setCrime(double crime) {
        this.crime = crime;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void updatePollutionEffects() {
        if (pollution > 60) {
            education = Math.max(0, education - 5);
            crime = Math.min(100, crime + 5);
        }
    }

    public void addDailyIncome() {
        budget += 50000;
    }

    public void saveCurrentState() {
        prevPopulation = population;
        prevPollution = pollution;
        prevEducation = education;
        prevHealth = health;
        prevCrime = crime;
        prevHappiness = happiness;
        prevBudget = budget;
    }

    public String getStatusEmoji(double value, double low, double medium, boolean isReverse) {
        if (isReverse) {
            if (value < low) {
                return "💚";
            } else if (value < medium) {
                return "💛";
            } else {
                return "❤️";
            }
        } else {
            if (value < low) {
                return "❤️";
            } else if (value < medium) {
                return "💛";
            } else {
                return "💚";
            }
        }
    }

    public String getChangeIndicator(double oldValue, double newValue) {
        if (newValue > oldValue) {
            return "↑";
        } else if (newValue < oldValue) {
            return "↓";
        } else {
            return "→";
        }
    }

    public void dailyReport(int day) {
        System.out.println("\n📅 ========== Hari ke-" + day + " ==========");
        System.out.println("🏙️ Status Kota:");
        System.out.println("👥 Penduduk: " + population + " " + getStatusEmoji(population, 300000, 700000, false) + " " + getChangeIndicator(prevPopulation, population));
        System.out.println("🌫️ Tingkat Polusi: " + pollution + "% " + getStatusEmoji(pollution, 30, 60, true) + " " + getChangeIndicator(prevPollution, pollution));
        System.out.println("📚 Tingkat Pendidikan: " + education + "% " + getStatusEmoji(education, 50, 80, false) + " " + getChangeIndicator(prevEducation, education));
        System.out.println("🏥 Tingkat Kesehatan: " + health + "% " + getStatusEmoji(health, 50, 80, false) + " " + getChangeIndicator(prevHealth, health));
        System.out.println("🚔 Tingkat Kriminalitas: " + crime + "% " + getStatusEmoji(crime, 20, 50, true) + " " + getChangeIndicator(prevCrime, crime));
        System.out.println("😊 Indeks Kebahagiaan: " + happiness + "% " + getStatusEmoji(happiness, 50, 80, false) + " " + getChangeIndicator(prevHappiness, happiness));
        System.out.println("💰 Anggaran Kota: $" + budget + " " + getStatusEmoji(budget, 500000, 2000000, false) + " " + getChangeIndicator(prevBudget, budget));
        System.out.println("====================================");

        saveCurrentState();
    }
}