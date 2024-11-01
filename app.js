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