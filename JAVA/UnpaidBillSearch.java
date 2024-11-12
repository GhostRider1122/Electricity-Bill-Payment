import java.util.Scanner;

class Bill {
    int consumerID;
    String customerName;
    double dueAmount;
    double payableAmount;

    // Constructor to initialize bill details
    public Bill(int consumerID, String customerName, double dueAmount, double payableAmount) {
        this.consumerID = consumerID;
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    // Method to display bill details
    public void display() {
        System.out.printf("%-12d | %-20s | %-12.2f | %-14.2f\n", consumerID, customerName, dueAmount, payableAmount);
    }
}

public class UnpaidBillSearch {
    private static final int MAX_BILLS = 5; // Fixed size for the bill array
    private static Bill[] bills = new Bill[MAX_BILLS];
    private static int billCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate the bill array with sample data
        addSampleBills();

        System.out.print("Enter Consumer ID to search for unpaid bills: ");
        int searchID = scanner.nextInt();

        // Search for unpaid bills based on Consumer ID
        searchUnpaidBillsByConsumerID(searchID);
    }

    // Method to search for unpaid bills by Consumer ID
    private static void searchUnpaidBillsByConsumerID(int consumerID) {
        boolean foundUnpaidBill = false;

        System.out.println("\nConsumer ID  | Customer Name        | Due Amount  | Payable Amount");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < billCount; i++) {
            if (bills[i].consumerID == consumerID && bills[i].dueAmount > bills[i].payableAmount) {
                bills[i].display();
                foundUnpaidBill = true;
            }
        }

        if (!foundUnpaidBill) {
            System.out.println("No unpaid bills found for Consumer ID: " + consumerID);
        }
    }

    // Method to add sample bills to the array
    private static void addSampleBills() {
        bills[billCount++] = new Bill(101, "Alice Smith", 200.50, 150.00);
        bills[billCount++] = new Bill(102, "Bob Johnson", 300.00, 300.00);
        bills[billCount++] = new Bill(103, "Charlie Brown", 500.00, 400.00);
        bills[billCount++] = new Bill(104, "David White", 250.00, 200.00);
        bills[billCount++] = new Bill(105, "Eve Black", 150.00, 100.00);
    }
}
