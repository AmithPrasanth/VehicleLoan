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

    
    function showLoanApplication() {
        document.getElementById('checkEligibility').style.display = 'none';
        document.getElementById('applyLoan').style.display = 'block';
        showPage(1);
    }

    function showPage(pageNumber) {
        const pages = document.querySelectorAll('.form-page');
        pages.forEach(page => page.style.display = 'none');
        document.getElementById('page' + pageNumber).style.display = 'block';
    }

    
    document.getElementById('checkEligibility').style.display = 'block';
    document.getElementById('applyLoan').style.display = 'none';

    
    document.getElementById('loanApplicationForm').addEventListener('submit', (event) => {
        if (!validateForm()) {
            event.preventDefault(); 
        }
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

        
        const minimumSalaryRequired = 20000; 
        const maxEmiPercentage = 0.4; 


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
            showLoanApplication(); 
        }
    }

    
    document.querySelector('#checkEligibility button').addEventListener('click', checkEligibility);
});
