// Inheritance
public class myPanel extends SolarPanel {

    public myPanel(String panelId, double capacity) {
        super(panelId, capacity);
    }

    @Override
    public double calculateEfficiency() {
        double efficiency = super.calculateEfficiency();
        if (efficiency == 0) {
            return 0;
        }

        return efficiency + 5.0;
    }
}
