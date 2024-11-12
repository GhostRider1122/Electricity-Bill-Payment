import java.util.Random;
import java.util.Scanner;

class Customer {
    int consumerId;
    int billNumber;
    String title;
    String customerName;
    String email;
    String mobileNumber;
    String userId;
    String password;

    // Constructor to initialize customer details
    public Customer(int consumerId, int billNumber, String title, String customerName, String email, String mobileNumber, String password) {
        this.consumerId = consumerId;
        this.billNumber = billNumber;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userId = generateUserId();
        this.password = password;
    }

    // Method to generate a random user ID
    private String generateUserId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder userId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            userId.append(chars.charAt(random.nextInt(chars.length())));
        }
        return userId.toString();
    }

    // Method to display customer details
    public void display() {
        System.out.println("Consumer ID: " + consumerId);
        System.out.println("Bill Number: " + billNumber);
        System.out.println("Title: " + title);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("User ID: " + userId);
        System.out.println("-----------------------------");
    }
}

public class CustomerRegistration {
    private static final int MAX_CUSTOMERS = 10;
    private static Customer[] customers = new Customer[MAX_CUSTOMERS];
    private static int customerCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCustomer Registration System");
            System.out.println("[1]. Add Customer");
            System.out.println("[2]. Display All Customers");
            System.out.println("[3]. Delete Customer");
            System.out.println("[4]. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    displayCustomers();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a customer
    private static void addCustomer() {
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("Customer limit reached. Cannot add more customers.");
            return;
        }

        System.out.print("Enter Consumer ID: ");
        int consumerId = scanner.nextInt();
        System.out.print("Enter Bill Number: ");
        int billNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Title (Mr/Ms): ");
        String title = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Mobile Number (10 digits): ");
        String mobileNumber = scanner.nextLine();

        // Password entry and confirmation
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
            return;
        }

        // Create a new customer object and add it to the array
        Customer newCustomer = new Customer(consumerId, billNumber, title, customerName, email, mobileNumber, password);
        customers[customerCount++] = newCustomer;
        System.out.println("Customer Registration is successful!");
    }

    // Method to display all customers
    private static void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers registered.");
        } else {
            System.out.println("\nRegistered Customers:");
            for (int i = 0; i < customerCount; i++) {
                customers[i].display();
            }
        }
    }

    // Method to delete a customer by Consumer ID
    private static void deleteCustomer() {
        if(customerCount == 0) {
            System.out.println("There are no customers registered yet.");
        }
        else{
            System.out.print("Enter Consumer ID to delete: ");
            int consumerId = scanner.nextInt();
            boolean found = false;

            // Find the customer to delete
            for (int i = 0; i < customerCount; i++) {
                if (customers[i].consumerId == consumerId) {
                    // Shift the elements to the left to delete the customer
                    for (int j = i; j < customerCount - 1; j++) {
                        customers[j] = customers[j + 1];
                    }
                    customers[--customerCount] = null; // Reduce count and set last element to null
                    found = true;
                    System.out.println("Customer deleted successfully.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Customer not found.");
            }
        }
        
    }
}
