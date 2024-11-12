import java.util.Scanner;

class Complaint {
    int consumerID;
    String customerName;
    String complaintType;
    String category;
    String problemDescription;
    String mobile;
    String status;

    // Constructor to initialize complaint details
    public Complaint(int consumerID, String customerName, String complaintType, String category,
                     String problemDescription, String mobile, String status) {
        this.consumerID = consumerID;
        this.customerName = customerName;
        this.complaintType = complaintType;
        this.category = category;
        this.problemDescription = problemDescription;
        this.mobile = mobile;
        this.status = status;
    }

    // Method to display complaint details
    public void display() {
        System.out.printf("%-12d | %-20s | %-15s | %-15s | %-20s | %-12s | %-10s\n", 
                          consumerID, customerName, complaintType, category, problemDescription, mobile, status);
    }
}

public class ComplaintSearch {
    private static final int MAX_COMPLAINTS = 5; // Fixed size for the complaint array
    private static Complaint[] complaints = new Complaint[MAX_COMPLAINTS];
    private static int complaintCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate the complaint array with sample data
        addSampleComplaints();

        System.out.println("Enter Consumer ID to view complaints: ");
        int searchID = scanner.nextInt();

        // Search for complaints based on Consumer ID
        searchComplaintsByConsumerID(searchID);
    }

    // Method to search for complaints by Consumer ID
    private static void searchComplaintsByConsumerID(int consumerID) {
        boolean foundComplaint = false;

        System.out.println("\nConsumer ID  | Customer Name        | Complaint Type   | Category         | Problem Description  | Mobile Number  | Status");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < complaintCount; i++) {
            if (complaints[i].consumerID == consumerID) {
                complaints[i].display();
                foundComplaint = true;
                break;
            }
        }

        if (!foundComplaint) {
            System.out.println("No complaints found for Consumer ID: " + consumerID);
        }
    }

    // Method to add sample complaints to the array
    private static void addSampleComplaints() {
        complaints[complaintCount++] = new Complaint(101, "Alice Smith", "Service", "Technical", 
                                                    "Internet not working", "9876543210", "Open");
        // complaints[complaintCount++] = new Complaint(102, "Bob Johnson", "Product", "Quality", 
        //                                             "Defective charger", "9123456780", "Closed");
        // complaints[complaintCount++] = new Complaint(103, "Charlie Brown", "Service", "Billing", 
        //                                             "Incorrect billing amount", "9234567891", "Open");
        // complaints[complaintCount++] = new Complaint(104, "David White", "Product", "Delivery", 
        //                                             "Delayed delivery", "9345678912", "Resolved");
        // complaints[complaintCount++] = new Complaint(105, "Eve Black", "Service", "Technical", 
        //                                             "Connection drops frequently", "9456789123", "Open");
    }
}
