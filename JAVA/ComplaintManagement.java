import java.util.Scanner;

class Complaint {
    String complaintType;
    String category;
    String landMark;
    String customerName;
    String problem;
    int consumerNumber;
    String address;
    String mobileNumber;
    int complaintId; // Unique complaint ID

    // Constructor to initialize complaint details
    public Complaint(int complaintId, String complaintType, String category, String landMark, String customerName, 
                     String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintId = complaintId;
        this.complaintType = complaintType;
        this.category = category;
        this.landMark = landMark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Method to display complaint details
    public void display() {
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Complaint Type: " + complaintType);
        System.out.println("Category: " + category);
        System.out.println("LandMark: " + landMark);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Problem: " + problem);
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Address: " + address);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("------------------------------");
    }
}

public class ComplaintManagement {
    private static final int MAX_COMPLAINTS = 10;
    private static Complaint[] complaints = new Complaint[MAX_COMPLAINTS];
    private static int complaintCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nComplaint Management System");
            System.out.println("1. Register Complaint");
            System.out.println("2. Delete Complaint");
            System.out.println("3. Display All Complaints");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    registerComplaint();
                    break;
                case 2:
                    deleteComplaint();
                    break;
                case 3:
                    displayAllComplaints();
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

    // Method to register a new complaint
    private static void registerComplaint() {
        if (complaintCount >= MAX_COMPLAINTS) {
            System.out.println("Complaint limit reached. Cannot register more complaints.");
            return;
        }

        System.out.print("Enter Complaint ID: ");
        int complaintId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Complaint Type: ");
        String complaintType = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter LandMark: ");
        String landMark = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Problem: ");
        String problem = scanner.nextLine();
        System.out.print("Enter Consumer Number: ");
        int consumerNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Mobile Number (10 digits): ");
        String mobileNumber = scanner.nextLine();

        // Create a new complaint object and add it to the array
        complaints[complaintCount++] = new Complaint(complaintId, complaintType, category, landMark, customerName, 
                                                      problem, consumerNumber, address, mobileNumber);
        System.out.println("Successfully registered Complaint!");
    }

    // Method to delete a complaint using complaint ID
    private static void deleteComplaint() {
        System.out.print("Enter Complaint ID to delete: ");
        int complaintId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < complaintCount; i++) {
            if (complaints[i].complaintId == complaintId) {
                // Shift the remaining elements to the left to fill the gap
                for (int j = i; j < complaintCount - 1; j++) {
                    complaints[j] = complaints[j + 1];
                }
                complaints[--complaintCount] = null; // Reduce count and set last element to null
                System.out.println("Complaint details are deleted.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Complaint not found.");
        }
    }

    // Method to display all complaints
    private static void displayAllComplaints() {
        if (complaintCount == 0) {
            System.out.println("No complaints registered.");
        } else {
            System.out.println("\nList of Complaints:");
            for (int i = 0; i < complaintCount; i++) {
                complaints[i].display();
            }
        }
    }
}
