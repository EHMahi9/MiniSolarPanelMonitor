import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MonitoringSystem system = new MonitoringSystem();

        while (true) {
            System.out.println("\n=== Solar Panel Monitor ===");
            System.out.println("1. Add Panel");
            System.out.println("2. Update Panel Data");
            System.out.println("3. Show All Panels");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Panel ID: ");
                        String id = sc.next();

                        System.out.print("Enter Capacity (W): ");
                        double cap = sc.nextDouble();

                        SolarPanel panel = new SolarPanel(id, cap);
                        system.addPanel(panel);

                        System.out.println("Panel added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Panel ID: ");
                        String pid = sc.next();

                        SolarPanel p = system.findPanel(pid);

                        if (p == null) {
                            System.out.println("Panel not found!");
                            break;
                        }

                        System.out.print("Enter Sunlight Hours: ");
                        double sun = sc.nextDouble();

                        System.out.print("Enter Actual Output: ");
                        double out = sc.nextDouble();

                        p.setSunlightHours(sun);
                        p.setActualOutput(out);

                        System.out.println("Updated successfully!");
                        break;

                    case 3:
                        system.showAllPanels();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
