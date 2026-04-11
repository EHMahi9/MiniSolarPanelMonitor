import java.util.ArrayList;

public class MonitoringSystem {
    private ArrayList<SolarPanel> panels;

    public MonitoringSystem() {
        panels = new ArrayList<>();
    }

    public void addPanel(SolarPanel panel) {
        panels.add(panel);
    }

    public SolarPanel findPanel(String id) {
        for (SolarPanel p : panels) {
            if (p.getPanelId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void showAllPanels() {
        if (panels.isEmpty()) {
            System.out.println("No panels available.");
            return;
        }

        for (SolarPanel p : panels) {
            p.displayInfo();
        }
    }
}
