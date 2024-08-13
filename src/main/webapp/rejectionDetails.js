function getQueryParameter(name) {
            const urlParams = new URLSearchParams(window.location.search);
			console.log("calling getQueryParameter");
			console.log(urlParams.get(name));
            return urlParams.get(name);
			
        }

document.addEventListener('DOMContentLoaded', () => {
	const loan_id = getQueryParameter('loan_id');
	console.log(loan_id);
	const apiUrlloan =`http://localhost:8085/VLC/resources/LoanService/loan/${loan_id}`;
    
    const signOutButton = document.getElementById('sign-out-button');
    
    
    signOutButton.addEventListener('click', () => {
       
        const userConfirmed = confirm('Are you sure you want to log out?');
        if (userConfirmed) {
          
            window.location.href = 'login.html'; 
        }
    });

    async function fetchData() {
        try {
			const response1 = await fetch(apiUrlloan);
			if (!response1.ok) {
			throw new Error('Network response was not ok');
			}
			const data1 = await response1.json();
			const cust_id = data1.customer_id;
			console.log(cust_id);
            const response2 = await fetch(`http://localhost:8085/VLC/resources/LoanService/customer/${cust_id}`);
            if (!response2.ok) {
                throw new Error('Network response was not ok');
            }
            const data2 = await response2.json();
			populateDetailscustomers(data2);
			const response3 = await fetch(`http://localhost:8085/VLC/resources/LoanService/vehicle/${cust_id}`);
			if (!response3.ok) {
			throw new Error('Network response was not ok');
			}
			const data3 = await response3.json();
            populateDetailsvehicles(data3);
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }

	function populateDetailscustomers(data) {
	            document.getElementById('customer-name').textContent = data.name || 'N/A';
	            document.getElementById('customer-email').textContent = data.email_id || 'N/A';
	            document.getElementById('customer-phone').textContent = data.mobile_number || 'N/A';
	            document.getElementById('customer-address').textContent ='N/A';
				}
				
	function populateDetailsvehicles(data) {
	            document.getElementById('vehicle-make').textContent = data.make || 'N/A';
	            document.getElementById('vehicle-model').textContent = data.model || 'N/A';
	            document.getElementById('vehicle-showroom').textContent = data.ex_showroom_price || 'N/A';
	            document.getElementById('vehicle-onroad').textContent = data.on_road_price || 'N/A';
	        }

    fetchData();
});