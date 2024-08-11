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

  
    showPage(1);
}

function showPage(pageNumber) {

    const pages = document.querySelectorAll('.form-page');
    pages.forEach(page => page.style.display = 'none');

 
    document.getElementById('page' + pageNumber).style.display = 'block';
}


document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('checkEligibility').style.display = 'block';
    document.getElementById('applyLoan').style.display = 'none';
});
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loanApplicationForm');
    
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