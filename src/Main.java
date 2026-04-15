import java.util.Scanner;

public class Main {
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }

            System.out.println("Error: please enter a whole number.");
            sc.next();
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }

            System.out.println("Error: please enter a valid number.");
            sc.next();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MonitoringSystem system = new MonitoringSystem();

        while (true) {
            System.out.println("\nWelcome to my Solar Panel Monitor System");
            System.out.println("1. Add Panel");
            System.out.println("2. Update Panel Data");
            System.out.println("3. Show All Panels");
            System.out.println("4. Exit");
            int choice = readInt(sc, "Choose: ");

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Panel ID: ");
                        String id = sc.next();

                        double cap = readDouble(sc, "Enter Capacity (W): ");

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

                        double sun = readDouble(sc, "Enter Sunlight Hours: ");

                        double out = readDouble(sc, "Enter Actual Output: ");

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
