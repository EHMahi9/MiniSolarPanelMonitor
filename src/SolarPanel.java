public class SolarPanel implements EnergyProducer {
    private String panelId;
    private double capacity; // max power in watts
    private double sunlightHours;
    private double actualOutput;

    // Constructor
    public SolarPanel(String panelId, double capacity) {
        this.panelId = panelId;
        this.capacity = capacity;
    }

    // Setters
    public void setSunlightHours(double sunlightHours) {
        if (sunlightHours < 0) {
            throw new IllegalArgumentException("Sunlight hours cannot be negative!");
        }
        this.sunlightHours = sunlightHours;
    }

    public void setActualOutput(double actualOutput) {
        if (actualOutput < 0) {
            throw new IllegalArgumentException("Output cannot be negative!");
        }
        this.actualOutput = actualOutput;
    }

    // Getters
    public String getPanelId() {
        return panelId;
    }

    public double getCapacity() {
        return capacity;
    }

    // Implement interface
    @Override
    public double generatePower() {
        return capacity * sunlightHours;
    }

    // Efficiency calculation
    public double calculateEfficiency() {
        double expected = generatePower();
        if (expected == 0) return 0;
        return (actualOutput / expected) * 100;
    }

    // Status check
    public String getStatus() {
        double eff = calculateEfficiency();

        if (eff >= 75) return "GOOD";
        else if (eff >= 40) return "LOW";
        else return "CRITICAL";
    }

    // Display
    public void displayInfo() {
        System.out.println("Panel ID: " + panelId);
        System.out.println("Capacity: " + capacity + "W");
        System.out.println("Sunlight Hours: " + sunlightHours);
        System.out.println("Actual Output: " + actualOutput + "W");
        System.out.printf("Efficiency: %.2f%%%n", calculateEfficiency());
        System.out.println("Status: " + getStatus());
        System.out.println("---------------------------");
    }
}
