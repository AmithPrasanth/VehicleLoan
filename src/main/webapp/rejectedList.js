document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'http://localhost:8085/VLC/resources/LoanService/rejectedloans/'; 
	const signOutButton = document.getElementById('sign-out-button');
	    	    
	signOutButton.addEventListener('click', () => {

	 const userConfirmed = confirm('Are you sure you want to log out?');
	 if (userConfirmed) {
	 
	 window.location.href = 'login.html'; 
	 }
	  });
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

	      
	      function populateTable(data) {
	          const tableBody = document.querySelector('#data-table');
	          tableBody.innerHTML = ''; 

	          data.forEach(application => {
	              const row = document.createElement('tr');
	              
	              const loanIdCell = document.createElement('td');
	              loanIdCell.textContent = application.loan_id;
	              row.appendChild(loanIdCell);
	  			
	  			const custIdCell = document.createElement('td');
	  			custIdCell.textContent = application.customer_id;
	  			row.appendChild(custIdCell);

	              const dateCell = document.createElement('td');
	              dateCell.textContent = application.date_of_loan;
	              row.appendChild(dateCell);

	          
	              const viewButtonCell = document.createElement('td');
	              const viewButton = document.createElement('button');
	  			
	              viewButton.textContent = 'View Details';
	              viewButton.addEventListener('click', () => {
	                  viewApplication(application.loan_id);
	              });
	              viewButtonCell.appendChild(viewButton);
	              row.appendChild(viewButtonCell);

	              tableBody.appendChild(row);
	          });
	      }

	  	function viewApplication(loan_id) {
	  	           const newPageUrl = `applicationDetails.html?loan_id=${loan_id}`;
	  	           window.location.href = newPageUrl;
	  	       }

    fetchData();
});