// Inheritance
public class myPanel extends SolarPanel {

    public myPanel(String panelId, double capacity) {
        super(panelId, capacity);
    }

    @Override
    public double calculateEfficiency() {
        double efficiency = super.calculateEfficiency() + 5.0;

        if (efficiency == 0) {
            return 0;
        }

        if (efficiency > 100.0) {
            return 100.0;
        }

        return efficiency;
    }
}
