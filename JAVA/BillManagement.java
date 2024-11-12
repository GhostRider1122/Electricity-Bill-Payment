import java.util.Scanner;

class Bill {
    int consumerNumber;
    double dueAmount;
    double payableAmount;

    // Constructor to initialize bill details
    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    // Method to display bill details
    public void display() {
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Due Amount: " + dueAmount);
        System.out.println("Payable Amount: " + payableAmount);
        System.out.println("-----------------------------");
    }
}

public class BillManagement {
    private static final int MAX_BILLS = 10;
    private static Bill[] bills = new Bill[MAX_BILLS];
    private static int billCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBill Management System");
            System.out.println("1. Add Bill");
            System.out.println("2. Update Amount Details");
            System.out.println("3. Delete Bill Details");
            System.out.println("4. Display All Bills");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBill();
                    break;
                case 2:
                    updateBill();
                    break;
                case 3:
                    deleteBill();
                    break;
                case 4:
                    displayAllBills();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a new bill
    private static void addBill() {
        if (billCount >= MAX_BILLS) {
            System.out.println("Bill limit reached. Cannot add more bills.");
            return;
        }

        System.out.print("Enter Consumer Number: ");
        int consumerNumber = scanner.nextInt();
        System.out.print("Enter Due Amount: ");
        double dueAmount = scanner.nextDouble();
        System.out.print("Enter Payable Amount: ");
        double payableAmount = scanner.nextDouble();

        // Create a new bill object and add it to the array
        bills[billCount++] = new Bill(consumerNumber, dueAmount, payableAmount);
        System.out.println("Bill details are added successfully!");
    }

    // Method to update the amount details for a specific consumer ID
    private static void updateBill() {
        System.out.print("Enter Consumer Number to update: ");
        int consumerNumber = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < billCount; i++) {
            if (bills[i].consumerNumber == consumerNumber) {
                System.out.print("Enter New Due Amount: ");
                double newDueAmount = scanner.nextDouble();
                System.out.print("Enter New Payable Amount: ");
                double newPayableAmount = scanner.nextDouble();

                bills[i].dueAmount = newDueAmount;
                bills[i].payableAmount = newPayableAmount;
                System.out.println("Bill details are updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Consumer not found.");
        }
    }

    // Method to delete bill details for a specific consumer ID
    private static void deleteBill() {
        System.out.print("Enter Consumer Number to delete: ");
        int consumerNumber = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < billCount; i++) {
            if (bills[i].consumerNumber == consumerNumber) {
                // Shift the remaining elements to the left to fill the gap
                for (int j = i; j < billCount - 1; j++) {
                    bills[j] = bills[j + 1];
                }
                bills[--billCount] = null; // Reduce count and set last element to null
                System.out.println("Bill details are deleted.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Consumer not found.");
        }
    }

    // Method to display all bills
    private static void displayAllBills() {
        if (billCount == 0) {
            System.out.println("No bills available.");
        } else {
            System.out.println("\nList of Bills:");
            for (int i = 0; i < billCount; i++) {
                bills[i].display();
            }
        }
    }
}
