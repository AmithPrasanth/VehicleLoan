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
