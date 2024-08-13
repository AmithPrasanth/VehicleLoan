document.addEventListener('DOMContentLoaded', function () {
	const signOutButton = document.getElementById('sign-out-button');
	    	    
	    	    signOutButton.addEventListener('click', () => {
	    	        // Display a confirmation dialog
	    	        const userConfirmed = confirm('Are you sure you want to log out?');
	    	        
	    	        if (userConfirmed) {
	    	            // Redirect to the login page
	    	            window.location.href = 'login.html'; // Replace with the path to your login page
	    	        }
	    	    });
        document.getElementById('applyLoanLink').addEventListener('click', function(event) {
        event.preventDefault(); 
        window.location.href = 'applyloan.html'; 
    });
    document.getElementById('emicalcLink').addEventListener('click', function(event) {
        event.preventDefault(); 
        window.location.href = 'emicalculator.html'; 
    });
    document.getElementById('home').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'clientDashboard.html';
    });
    document.getElementById('aboutus').addEventListener('click', function(event) {
    event.preventDefault(); 
    window.location.href = 'aboutUs.html';
    });
});