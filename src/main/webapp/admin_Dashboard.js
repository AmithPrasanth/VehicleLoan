document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'http://localhost:8085/VLC/resources/LoanService/customers/'; // Replace with your API URL
	const signOutButton = document.getElementById('sign-out-button');
	    	    
	signOutButton.addEventListener('click', () => {
	 // Display a confirmation dialog
	 const userConfirmed = confirm('Are you sure you want to log out?');
	 if (userConfirmed) {
	 // Redirect to the login page
	 window.location.href = 'login.html'; // Replace with the path to your login page
	 }
	  });
	  // Function to fetch data from the API
	      async function fetchData() {
	          try {
	              const response = await fetch(apiUrl);
	              if (!response.ok) {
	                  throw new Error('Network response was not ok');
	              }
	              const data = await response.json();
	              populateTable(data);
	          } catch (error) {
	              console.error('There was a problem with the fetch operation:', error);
	          }
	      }

	      // Function to populate the table with data
	      function populateTable(data) {
	          const tableBody = document.querySelector('#data-table');
	          tableBody.innerHTML = ''; // Clear existing table rows

	          data.forEach(application => {
	              const row = document.createElement('tr');
	              
	              const custIdCell = document.createElement('td');
	              custIdCell.textContent = application.customer_id;
	              row.appendChild(custIdCell);
	  			
	  			const nameCell = document.createElement('td');
	  			nameCell.textContent = application.name;
	  			row.appendChild(nameCell);

	              const numCell = document.createElement('td');
	              numCell.textContent = application.mobile_number;
	              row.appendChild(numCell);

	              const emailCell = document.createElement('td');
	              emailCell.textContent = application.email_id;
	              row.appendChild(emailCell);

	              const viewButtonCell = document.createElement('td');
	              const viewButton = document.createElement('button');
	  			
	              viewButton.textContent = 'View Details';
	              viewButton.addEventListener('click', () => {
	                  viewApplication(application.customer_id);
	              });
	              viewButtonCell.appendChild(viewButton);
	              row.appendChild(viewButtonCell);

	              tableBody.appendChild(row);
	          });
	      }

	  	function viewApplication(cust_id) {
	  	           const newPageUrl = `clientDetails.html?loan_id=${cust_id}`;
	  	           window.location.href = newPageUrl;
	  	       }

	      
    // Fetch and display data when the page loads
    fetchData();
});