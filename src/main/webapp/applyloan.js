document.addEventListener('DOMContentLoaded', function() {
    const modal = document.getElementById('signoutSection');
    const closeModal = document.getElementById('closeModal');
    const signoutLink = document.getElementById('signout');
    const confirmSignout = document.getElementById('confirmSignout');
    const cancelSignout = document.getElementById('cancelSignout');

    signoutLink.addEventListener('click', function(event) {
        event.preventDefault();
        modal.style.display = 'flex';
    });

    closeModal.addEventListener('click', function() {
        modal.style.display = 'none';
    });

    confirmSignout.addEventListener('click', function() {
        alert('Signing out...');
        modal.style.display = 'none';
    });

    cancelSignout.addEventListener('click', function() {
        modal.style.display = 'none';
    });
});

function showLoanApplication() {
    document.getElementById('checkEligibility').style.display = 'none';
    document.getElementById('applyLoan').style.display = 'block';
    showPage(1); // Start at the first page of the loan application form
}

function showPage(pageNumber) {
    const pages = document.querySelectorAll('.form-page');
    pages.forEach(page => page.style.display = 'none');
    document.getElementById('page' + pageNumber).style.display = 'block';
    updateProgressBar();
}

function updateProgressBar() {
    const pages = document.querySelectorAll('.form-page');
    const totalFields = [];
    const filledFields = [];

    pages.forEach(page => {
        const fields = page.querySelectorAll('input[required], select[required], textarea[required]');
        totalFields.push(...fields);
        
        fields.forEach(field => {
            if (field.value.trim() !== '') {
                filledFields.push(field);
            }
        });
    });

    const progressPercentage = (filledFields.length / totalFields.length) * 100;
    const progressBar = document.getElementById('progressBar');
    progressBar.style.width = progressPercentage + '%';
    progressBar.textContent = Math.round(progressPercentage) + '% Complete';
}

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('checkEligibility').style.display = 'block';
    document.getElementById('applyLoan').style.display = 'none';
});

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loanApplicationForm');
    
    form.addEventListener('input', updateProgressBar); // Update progress bar on any input change
    form.addEventListener('submit', (event) => {
        if (!validateForm()) {
            event.preventDefault(); 
        }
    });
});

function validateForm() {
    const name = document.getElementById('customerName').value;
    const age = parseInt(document.getElementById('age').value, 10);
    
    const namePattern = /^[A-Za-z\s]+$/;
    if (!namePattern.test(name)) {
        alert('Name must contain only alphabets.');
        return false; 
    }
    
    if (isNaN(age) || age <= 18) {
        alert('Age must be greater than 18.');
        return false; 
    }
    return true;
}

function checkEligibility() {
    const salary = parseFloat(document.getElementById('salary').value);
    const existingEmis = parseFloat(document.getElementById('existingEmis').value);
    const vehiclePrice = parseFloat(document.getElementById('vehiclePrice').value);

    // Constants
    const minimumSalaryRequired = 20000; // Minimum salary required for loan eligibility
    const maxEmiPercentage = 0.4; // 40% of salary can be used for EMIs

    // Eligibility checks
    if (salary < minimumSalaryRequired) {
        alert('Salary must be at least ' + minimumSalaryRequired + ' to be eligible for a loan.');
        return;
    }

    const maxEmi = salary * maxEmiPercentage;
    const availableEmi = maxEmi - existingEmis;

    if (availableEmi < vehiclePrice) {
        alert('Based on your salary and existing EMIs, you are not eligible for this loan.');
    } else {
        alert('Congratulations! You are eligible for the loan.');
        showLoanApplication(); // Show loan application form if eligible
    }
}

// Bind the eligibility check function to the button click
document.querySelector('#checkEligibilityButton').addEventListener('click', checkEligibility);
document.getElementById('emicalcLink').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'emicalculator.html'; 
});
document.getElementById('applyLoanLink').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'applyloan.html'; 
});
document.getElementById('home').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'clientDashboard.html'; 
});
document.getElementById('aboutus').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'aboutus.html';
});
document.addEventListener('DOMContentLoaded', () => {
    // Get the loan application form
    const form = document.getElementById('loanApplicationForm');

    // Handle form submission
    form.addEventListener('submit', async function(event) {
        event.preventDefault(); // Prevent the default form submission behavior

        // Validate the form data
        if (!validateForm()) {
            return; // Stop form submission if validation fails
        }

        // Gather form data
        const formData = new FormData(form);
        const customerData = {
			customer_id: getCookie('customer_id'),
            name: formData.get('customerName'),
			age: formData.get('customerAge'),
			gender: formData.get('customerGender'),
			type_of_employment: formData.get('customerEmployment'),
			salary: formData.get('customerSalary'),
			balance: formData.get('customerBalance'),
			existing_emis: formData.get('customerEmis'),
            email_id: formData.get('customerEmail'),
            mobile_number: formData.get('customerPhone'),
            //customerAddress: formData.get('customerAddress')
        };
		console.log(customerData);
		const vehicleid=generateRandomVehicleId();
        const vehicleData = {
			vehicle_id: vehicleid,
            make: formData.get('vehicleMake'),
            model: formData.get('vehicleModel'),
            ex_showroom_price: formData.get('vehiclePrice'),
			on_road_price: formData.get('vehicleRoadPrice'),
			cust_id: getCookie('customer_id')
        };
		console.log(vehicleData);
		const loanId = generateRandomLoanId();
		const loanAmount = parseFloat(formData.get('loanAmount'));
		const loanTerm = formData.get('loanTerm');
		// Define the loan rate of interest
		const loanRateOfInterest = 14;

		// Calculate the total amount to pay
		const totalAmountToPay = loanAmount + (loanAmount * loanRateOfInterest / 100);

		// The amount left to pay is initially the same as the total amount to pay
		const amountLeftToPay = totalAmountToPay;
		const status_of_loan = 'Pending';
		// Get the current date
		const loanDate = new Date().toISOString().split('T')[0]; // Format as YYYY-MM-DD
        const loanData = {
			loan_id: loanId,
			loan_number: loanId,
			amount: loanAmount,
			customer_id: getCookie('customer_id'),
			tenure: loanTerm,
			rate_of_interest: loanRateOfInterest,
			total_amount_to_pay: totalAmountToPay,
			amount_left_to_pay: amountLeftToPay,
			loanDate: '2024-08-14',
			status_of_loan: status_of_loan
            //loanPurpose: formData.get('loanPurpose')
        };
		console.log(loanData);
        try {
            // Send customer details
            const customerResponse = await fetch('http://localhost:8085/VehicleLoanAPI/resources/LoanService/customer/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(customerData),
            });

            if (!customerResponse.ok) {
                throw new Error('Failed to save customer details');
            }

            // Send vehicle details
            const vehicleResponse = await fetch('http://localhost:8085/VehicleLoanAPI/resources/LoanService/vehicle/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(vehicleData),
            });

            if (!vehicleResponse.ok) {
                throw new Error('Failed to save vehicle details');
            }

            // Send loan details
            const loanResponse = await fetch('http://localhost:8085/VehicleLoanAPI/resources/LoanService/loan/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loanData),
            });

            if (!loanResponse.ok) {
                throw new Error('Failed to save loan details');
            }

            // Handle file uploads if needed
            //const fileData = new FormData();
            //fileData.append('aadharCard', formData.get('aadharCard'));
            //fileData.append('panCard', formData.get('panCard'));

            //const fileResponse = await fetch('http://localhost:8085/VLC/resources/LoanService/documents/', {
                //method: 'POST',
                //body: fileData,
            //});

            //if (!fileResponse.ok) {
            //    throw new Error('Failed to upload documents');
            //}

            alert('Application submitted successfully!');
            form.reset(); // Clear the form
            showPage(1); // Go back to the first page
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
            alert('There was an error submitting your application. Please try again.');
        }
    });

    // Form validation function
    function validateForm() {
        const name = document.getElementById('customerName').value;
        const age = parseInt(document.getElementById('age').value, 10);

        const namePattern = /^[A-Za-z\s]+$/;
        if (!namePattern.test(name)) {
            alert('Name must contain only alphabets.');
            return false;
        }

        if (isNaN(age) || age <= 18) {
            alert('Age must be greater than 18.');
            return false;
        }
        return true;
    }
});
function getCookie(name) {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') c = c.substring(1);
        if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}
function generateRandomVehicleId() {
        return Math.floor(Math.random() * 1000000); // Generates a random integer between 0 and 999999
    };
function generateRandomLoanId() {
        return Math.floor(Math.random() * 1000000); // Generates a random integer between 0 and 999999
    };
document.addEventListener('DOMContentLoaded', () => {
    displayCustomerId();
});

// Function to get a cookie by name
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}


function displayCustomerId() {
    const customerId = getCookie('customerId');
    const customerIdDisplay = document.getElementById('customerIdDisplay');
    if (customerId) {
        customerIdDisplay.textContent = `Your Customer ID is: ${customerId}`;
    } else {
        customerIdDisplay.textContent = 'No Customer ID found.';
    }
}