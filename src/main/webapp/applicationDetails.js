document.addEventListener('DOMContentLoaded', function() {
    // Simulate fetching data from an API
    const applicationId = getQueryParam('id'); // Get application ID from the URL
    if (!applicationId) {
        console.error('Application ID not found.');
        return;
    }

    fetch(`https://api.example.com/applications/${applicationId}`)
        .then(response => response.json())
        .then(data => {
            // Populate customer details
            document.getElementById('customer-name').textContent = data.customer.name;
            document.getElementById('customer-email').textContent = data.customer.email;
            document.getElementById('customer-phone').textContent = data.customer.phone;
            document.getElementById('customer-address').textContent = data.customer.address;
            
            // Populate vehicle details
            document.getElementById('vehicle-make').textContent = data.vehicle.make;
            document.getElementById('vehicle-model').textContent = data.vehicle.model;
            document.getElementById('vehicle-year').textContent = data.vehicle.year;
            document.getElementById('vehicle-reg-number').textContent = data.vehicle.registrationNumber;
            
            // Populate documents
            document.getElementById('doc-aadhar').href = data.documents.aadharUrl;
            document.getElementById('doc-payslip').href = data.documents.payslipUrl;
        })
        .catch(error => {
            console.error('Error fetching application details:', error);
        });

    document.getElementById('accept-button').addEventListener('click', function() {
        updateApplicationStatus(applicationId, 'Accepted');
    });

    document.getElementById('reject-button').addEventListener('click', function() {
        updateApplicationStatus(applicationId, 'Rejected');
    });
});

function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

function updateApplicationStatus(applicationId, status) {
    fetch(`https://api.example.com/applications/${applicationId}/status`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ status: status })
    })
    .then(response => response.json())
    .then(data => {
        alert(`Application ${status}`);
        window.location.href = 'application.html'; // Redirect to applications list
    })
    .catch(error => {
        console.error('Error updating application status:', error);
    });
}
