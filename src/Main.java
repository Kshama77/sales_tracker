import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Sale> sales = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("================================");
        System.out.println("       SALES TRACKER");
        System.out.println("================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addSale();
                case 2 -> viewSales();
                case 3 -> showSummary();
                case 4 -> searchSales();
                case 5 -> running = false;
                default -> System.out.println("Invalid option. Please choose 1-5.");
            }
        }

        System.out.println("Thank you for using SalesTracker!");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n--- MENU ---");
        System.out.println("1. Add a sale");
        System.out.println("2. View all sales");
        System.out.println("3. View revenue summary");
        System.out.println("4. Search sales by product");
        System.out.println("5. Exit");
    }

    private static void addSale() {
        System.out.println("\\n--- Add a Sale ---");
        System.out.print("Product name: ");
        String product = scanner.nextLine().trim();

        if (product.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        int quantity = readInt("Quantity sold: ");
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        double price = readDouble("Price per item ($): ");
        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        Sale sale = new Sale(product, quantity, price);
        sales.add(sale);
        System.out.printf("Sale added! Total: $%.2f%n", sale.getTotal());
    }

    private static void viewSales() {
        System.out.println("\\n--- All Sales ---");
        if (sales.isEmpty()) {
            System.out.println("No sales recorded yet.");
            return;
        }

        System.out.printf("%-4s %-22s %-10s %-12s %-12s%n",
                "No.", "Product", "Quantity", "Unit Price", "Total");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < sales.size(); i++) {
            Sale sale = sales.get(i);
            System.out.printf("%-4d %-22s %-10d $%-11.2f $%-11.2f%n",
                    i + 1, sale.getProduct(), sale.getQuantity(),
                    sale.getUnitPrice(), sale.getTotal());
        }
    }

    private static void showSummary() {
        int totalItems = 0;
        double revenue = 0;

        for (Sale sale : sales) {
            totalItems += sale.getQuantity();
            revenue += sale.getTotal();
        }

        System.out.println("\\n--- Revenue Summary ---");
        System.out.println("Number of sales: " + sales.size());
        System.out.println("Items sold: " + totalItems);
        System.out.printf("Total revenue: $%.2f%n", revenue);
    }

    private static void searchSales() {
        System.out.print("\\nEnter product name to search: ");
        String search = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Sale sale : sales) {
            if (sale.getProduct().toLowerCase().contains(search)) {
                System.out.printf("%s | Quantity: %d | Unit price: $%.2f | Total: $%.2f%n",
                        sale.getProduct(), sale.getQuantity(),
                        sale.getUnitPrice(), sale.getTotal());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching sales found.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (example: 12.50).");
            }
        }
    }
}
