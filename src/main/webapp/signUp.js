// signup.js

document.addEventListener('DOMContentLoaded', () => {
    const signupButton = document.getElementById('signupButton');
   

    signupButton.addEventListener('click', () => {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (password !== confirmPassword) {
            alert('Passwords do not match!');
            return;
        }

        if (!validatePassword(password)) {
            alert('Password must be at least 8 characters long and include a number.');
            return;
        }

        const customerId = generateCustomerId();
        setCookie('customerId', customerId, 7); // Set cookie for 7 days

        const userData = {
			cust_id: customerId,
            username: username,
            password: password
        };

        // Send user data to backend
        fetch('http://localhost:8085/VLC/resources/LoanService/credential/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Signup successful!');
                showCustomerIdAndRedirect();
            } else {
                alert('Signup failed: ' + data.message);
            }
        })
        .catch(error => console.error('Error:', error));
        showCustomerIdAndRedirect();
    });

    

function generateCustomerId() {
    return Math.floor(Math.random() * 1000000); // Generate a random integer customer ID
}

function setCookie(name, value, days) {
    let expires = "";
    if (days) {
        const date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000)); // days in milliseconds
        expires = "expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "") + ";" + expires + ";path=/";
}

function validatePassword(password) {
    const minLength = 8;
    const numberPattern = /\d/;
    return password.length >= minLength && numberPattern.test(password);
}

function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

function showCustomerIdAndRedirect() {
    const customerId = getCookie('customerId');
    if (customerId) {
        alert(`Your Customer ID is: ${customerId}`);
        window.location.href = 'login.html'; // Redirect to the login page
    } else {
        alert('No Customer ID found.');
    }
}
});