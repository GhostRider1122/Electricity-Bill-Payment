import java.util.Scanner;

class Customer {
    int consumerID;
    String customerName;
    String mobileNumber;
    String email;

    // Constructor to initialize customer details
    public Customer(int consumerID, String customerName, String mobileNumber, String email) {
        this.consumerID = consumerID;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    // Method to display customer details
    public void display() {
        System.out.printf("%-12d | %-20s | %-15s | %-25s\n", consumerID, customerName, mobileNumber, email);
    }
}

public class ConsumerDetailsSearch {
    private static final int MAX_CUSTOMERS = 5; // Fixed size for the customer array
    private static Customer[] customers = new Customer[MAX_CUSTOMERS];
    private static int customerCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate the customer array with sample data
        addSampleCustomers();

        System.out.print("Enter Consumer ID to search: ");
        int searchID = scanner.nextInt();

        // Search for the customer by Consumer ID
        searchCustomerByConsumerID(searchID);
    }

    // Method to search for a customer by Consumer ID
    private static void searchCustomerByConsumerID(int consumerID) {
        boolean found = false;

        System.out.println("\nConsumer ID  | Customer Name        | Mobile Number   | Email");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < customerCount; i++) {
            if (customers[i].consumerID == consumerID) {
                customers[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No customer found with Consumer ID: " + consumerID);
        }
    }

    // Method to add sample customers to the array
    private static void addSampleCustomers() {
        customers[customerCount++] = new Customer(101, "Alice Smith", "9876543210", "alice@example.com");
        customers[customerCount++] = new Customer(102, "Bob Johnson", "9123456780", "bob@example.com");
        customers[customerCount++] = new Customer(103, "Charlie Brown", "9234567891", "charlie@example.com");
        customers[customerCount++] = new Customer(104, "David White", "9345678912", "david@example.com");
        customers[customerCount++] = new Customer(105, "Eve Black", "9456789123", "eve@example.com");
    }
}
