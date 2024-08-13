// signup.js

document.addEventListener('DOMContentLoaded', () => {
    const signupButton = document.getElementById('signupButton');
    const signupForm = document.getElementById('signupForm');

    // Function to generate a random integer
    function generateRandomCustomerId() {
        return Math.floor(Math.random() * 1000000); // Generates a random integer between 0 and 999999
    };
	function setCookie(name, value, days) {
	        let expires = "";
	        if (days) {
	            const date = new Date();
	            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	            expires = "; expires=" + date.toUTCString();
	        };
	        document.cookie = name + "=" + (value || "") + expires + "; path=/";
	    };
    // Function to handle form submission
    async function handleSignup() {
        // Get form values
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        // Basic validation
        if (password !== confirmPassword) {
            alert('Passwords do not match!');
            return;
        }

        // Generate random customer ID
        const customerId = generateRandomCustomerId();

        // Data to send
        const userData = {
            username,
            password,
            customerId: customerId
        };

        try {
            // Send data to the server using fetch API
            const response = await fetch('http://localhost:8085/VehicleLoanAPI/resources/LoanService/credential/add', { // Replace with your API endpoint
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            if (response.ok) {
                const responseData = await response.json();
                alert('Signup successful!');
                // Optionally, redirect to another page or clear the form
				setCookie('customer_id', customerId, 7); // Cookie expires in 7 days

                window.location.href = 'login.html';
            } else {
                alert('Signup failed. Please try again.');
            }
        } catch (error) {
            console.error('Error during signup:', error);
            alert('An error occurred. Please try again.');
        }
    }

    // Attach event listener to the signup button
    signupButton.addEventListener('click', handleSignup);
});
