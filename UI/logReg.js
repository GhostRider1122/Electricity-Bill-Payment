// Customer Registration Part
function register() {
    const consumerId = document.getElementById("consumerId").value;
    const billNumber = document.getElementById("billNumber").value;
    const title = document.getElementById("title").value;
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const mobile = document.getElementById("mobile").value;
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    // Validate consumer Id field
    if ( consumerId.length != 13) 
        {
            alert("Please enter 13 digits in Consumer ID.");
            return;  
        }

    // Validate Bill Number field
    if ( billNumber.length !== 5 ) 
        {
            alert("Please enter last 5 digits of bill number.");
            return;  
        }

    // Validate consumer name field
    if ( name.length > 50 || name.length < 2 ) 
        {
            alert("Please enter a name within 50 characters or less.");
            return;  
        }

    // Validate phone number
    if (mobile.length !== 10) 
    {
        alert("Enter phone number of valid length");
        return;
    }

    // Validate user id
    if (userId.length < 5 || userId.length > 20)
    {
        alert("User ID should be of length 5-20 character");
        return;
    }

    // Validate password
    if (password.length < 8)
    {
        alert("Enter a vaild password of length 8 or more");
        return;
    }

    //Check if the passwords match
    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return;
    }

    const generatedId = Math.floor(Math.random() * 10000000000000); // Random 13-digit ID

    // Hide the form and show acknowledgment screen
    document.getElementById("registrationForm").style.display = "none";
    document.getElementById("acknowledgment").style.display = "block";

    document.getElementById("generatedId").textContent = generatedId;
    document.getElementById("displayName").textContent = name;
    document.getElementById("displayEmail").textContent = email;
}

function resetForm() {
    document.getElementById("registrationForm").reset();
    document.getElementById("registrationForm").style.display = "block";
    document.getElementById("acknowledgment").style.display = "none";
}



// Customer Login part

// Mock database of registered users
const registeredUsers = [
    { customerId: '12345', password: 'password123' },
    { customerId: 'admin', password: 'pass'}
];

function loginUser() {
    // Retrieve input values
    const customerId = document.getElementById('customerId').value;
    const password = document.getElementById('password').value;
    
    // Clear previous error messages
    document.getElementById('idError').textContent = '';
    document.getElementById('passwordError').textContent = '';
    document.getElementById('generalError').textContent = '';

    // Check if customer ID and password are valid
    const user = registeredUsers.find(user => user.customerId === customerId);

    if (!user) {
        // Customer ID not found
        document.getElementById('idError').textContent = 'ID not valid';
        document.getElementById('generalError').textContent = 'ID/password not valid';
        return;
    }
    if (user.password !== password) {
        // Password incorrect
        document.getElementById('passwordError').textContent = 'Password not valid';
        document.getElementById('generalError').textContent = 'ID/password not valid';
        return;
    }

    // If login is successful
    // Save user ID in localStorage and navigate to home page
    localStorage.setItem('loggedInUser', customerId);
    alert('Login successful!');
    window.location.href = 'home.html';  // Redirect to home page

}

