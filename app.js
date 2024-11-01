// Calculate total amount in Pay Bill page
function calculateTotal() {
    const checkboxes = document.querySelectorAll('input[name="bill"]:checked');
    let total = 0;
    checkboxes.forEach(checkbox => {
        total += parseInt(checkbox.value);
    });

    // Display the total amount with a dollar sign
    document.getElementById("totalAmount").textContent = `₹${total}`;
    
    // Enable or disable the "Proceed to Pay" button based on the total amount
    document.getElementById("proceedButton").disabled = total === 0;
}

// Proceed to payment page
function proceedToPay() {
    const totalAmount = document.getElementById("totalAmount").textContent.replace('₹', ''); // Remove dollar sign
    if (parseInt(totalAmount) > 0) {
        localStorage.setItem("billAmount", totalAmount);
        window.location.href = 'payment.html';
    } else {
        alert("Please select at least one bill to proceed with payment.");
    }
}


// Display bill amount on Payment page
window.onload = function() {
    const billAmount = localStorage.getItem("billAmount") || 0;
    document.getElementById("billAmount").textContent = billAmount;
    document.getElementById("totalPayable").textContent = parseInt(billAmount) + 10; // Adding PG Charge
};

function backToHome() {
    window.location.href = 'home.html';
}

// Validate and submit the complaint form
function submitComplaint() {
    const consumerNo = document.getElementById("consumerNo").value;
    const mobile = document.getElementById("mobile").value;

    if (consumerNo.length !== 13) {
        alert("Consumer Number must be 13 digits.");
        return;
    }

    if (mobile.length !== 10) {
        alert("Mobile Number must be 10 digits.");
        return;
    }

    alert("Complaint Registered successfully! Your complaint ID is: " + Math.floor(Math.random() * 1000000));
    window.location.href = 'registerComplaint.html';
}

function resetForm() {
    // Reset the form fields
    document.getElementById("complaintForm").reset();

    // Optionally, reset any selected category or additional state if needed
    document.getElementById("category").innerHTML = ""; // Reset the category dropdown
    document.getElementById("contactPerson").value = ""; // Reset contact person input
    document.getElementById("landmark").value = ""; // Reset landmark input
    document.getElementById("consumerNo").value = ""; // Reset consumer number input
    document.getElementById("problemDescription").value = ""; // Reset problem description textarea
    document.getElementById("mobileNumber").value = ""; // Reset mobile number input
    document.getElementById("address").value = ""; // Reset address textarea

}


// Mock database of complaints
const complaints = [
    { id: '123456', status: 'In Progress' },
    { id: '234567', status: 'Resolved' },
    { id: '345678', status: 'Pending' }
];

// Function to check complaint status
function checkComplaintStatus() {
    const complaintId = document.getElementById("complaintId").value;
    const complaint = complaints.find(c => c.id === complaintId);

    const statusResult = document.getElementById("statusResult");
    
    if (complaint) {
        statusResult.innerHTML = `<p style='font-weight: bold;'>Complaint ID: ${complaint.id}</p><p style='font-weight: bold;'>Status: ${complaint.status}</p>`;
    } 
    else {
        statusResult.innerHTML = "<p style='color:red; font-weight: bold;'>Complaint ID not found.</p>";
    }
}


// Highlight the active link in the navigation bar
function setActiveNavLink() {
    const navLinks = document.querySelectorAll("nav ul li a");
    const currentPath = window.location.pathname;

    navLinks.forEach(link => {
        if (link.getAttribute("href") === currentPath.split('/').pop()) {
            link.classList.add("active");
        } else {
            link.classList.remove("active");
        }
    });
}

// Call the function to set the active link when the page loads
window.onload = setActiveNavLink;

// Display the welcome message
function displayWelcomeMessage() {
    const userId = localStorage.getItem('loggedInUser');
    if (userId) {
        document.getElementById('username').textContent = `Welcome,${userId}`;
    } else {
        // Redirect to login page if no user is logged in
        window.location.href = 'login.html';
    }
}

// Logout function to clear localStorage and redirect to login page
function logout() {

    // Display a confirmation dialog
    const confirmLogout = confirm("Are you sure you want to log out?");
    
    if (confirmLogout) {
        localStorage.removeItem('loggedInUser');
        window.location.href = 'login.html';
    }
}

// Run displayWelcomeMessage when the page loads
window.onload = function() {
    displayWelcomeMessage();
    setActiveNavLink(); // Call to keep active link highlighted if used
};

// Populate category based on complaint type
function updateCategoryOptions() {
    const complaintType = document.getElementById("complaintType").value;
    const categorySelect = document.getElementById("category");

    // Clear existing options
    categorySelect.innerHTML = "<option value=''>Select Category</option>";

    const categories = {
        Billing: ["Incorrect Bill", "Bill Due Date", "Current Rate", "Late Payment Fee"],
        Voltage: ["High Voltage Issue", "Low Voltage Issue", "Voltage Fluctuations"],
        Disruption: ["Frequent Outages", "Scheduled Outage", "Intermittent Power Supply"],
        StreetLight: ["Street Light Not Working", "Street Light Flickering", "Request New Street Light"],
        Pole: ["Leaning Pole", "Damaged Pole", "Request for Pole Relocation"]
    };

    if (categories[complaintType]) {
        categories[complaintType].forEach(cat => {
            const option = document.createElement("option");
            option.value = cat;
            option.textContent = cat;
            categorySelect.appendChild(option);
        });
    }
}

window.onload = function () {
    if (performance.navigation.type === performance.navigation.TYPE_BACK_FORWARD) {
        window.location.reload();
    }
};

//Payment page JS

// Retrieve the bill amount from localStorage
const billAmount = localStorage.getItem("billAmount");
const username = "JohnDoe"; // Replace with actual user data
const pgCharge = 50; // Fixed PG charge

// Initialize the page
document.getElementById("username").textContent = username;
document.getElementById("billAmount").textContent = `₹${billAmount}`;
const totalAmount = parseInt(billAmount) + pgCharge;
document.getElementById("totalAmount").textContent = `₹${totalAmount}`;

// Function to redirect to the home page
function redirectToHome() {
    window.location.href = 'home.html';
}

// Function to show credit card form
function proceedToPayment() {

    const paymentMode = document.getElementById("paymentMode").value;

    // Validate payment method selection
    if (paymentMode === "") {
        alert("Please select a payment method.");
        return;
    }

    document.getElementById("creditCardForm").classList.remove("hidden");
}

// Function to process payment
function makePayment() {
    const cardNumber = document.getElementById("cardNumber").value;
    const cardHolderName = document.getElementById("cardHolderName").value;
    const expiryDate = document.getElementById("expiryDate").value;
    const cvv = document.getElementById("cvv").value;

    // Basic validation
    function validateExpiryDate(expiryDate) {
        // Regular expression to check if the input follows MM/YY format
        const expDateRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;
    
        // Check if the input matches the MM/YY format
        if (!expDateRegex.test(expiryDate)) {
            alert("Please enter a valid expiration date in MM/YY format.");
            return false;
        }
    
        // Extract month and year from the input
        const [month, year] = expiryDate.split('/').map(num => parseInt(num, 10));
        
        // Get the current date
        const currentDate = new Date();
        const currentMonth = currentDate.getMonth() + 1; // Months are 0-based
        const currentYear = parseInt(currentDate.getFullYear().toString().slice(-2), 10); // Last two digits of the year
    
        // Check if the expiration date is in the future
        if (year < currentYear || (year === currentYear && month < currentMonth)) {
            alert("The expiration date must be in the future.");
            return false;
        }
    
        return true;
    }

    if (cardNumber.length !== 16) {
        alert("Please enter 16 digits of the card.");
        return;
    }

    if (cardHolderName === "") {
        alert("Please enter a valid name");
        return;
    }

    // Validate the expiration date
    if (!validateExpiryDate(expiryDate)) {
        return; 
    }

    if (cvv.length !== 3) {
        alert("Please enter 3 digits of CVV.");
        return;
    }

    // Simulate a successful transaction
    document.getElementById("transactionInfo").textContent = `Payment of ₹${totalAmount} was successful using ${document.getElementById("paymentMode").value}.`;
    document.getElementById("transactionDetails").classList.remove("hidden");
    document.getElementById("downloadButton").classList.remove("hidden");
}

// Function to download receipt
function downloadReceipt() {
    const link = document.createElement('a');
    link.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(document.getElementById("transactionInfo").textContent));
    link.setAttribute('download', 'receipt.txt');
    link.click();
}
