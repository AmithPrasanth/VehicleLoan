function getQueryParameter(name) {
            const urlParams = new URLSearchParams(window.location.search);
			console.log("calling getQueryParameter");
			console.log(urlParams.get(name));
            return urlParams.get(name);
			
        }

document.addEventListener('DOMContentLoaded', () => {
	const cust_id = getQueryParameter('cust_id');
	console.log(cust_id);
	//const apiUrlcust =`http://localhost:8085/VLC/resources/LoanService/customer/${cust_id}`;
    const apiUrlcust = 'http://localhost:8085/VLC/resources/LoanService/customer/1001'; // Replace with your API URL
    const signOutButton = document.getElementById('sign-out-button');
    
    // Event listener for the sign-out button
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
			const response1 = await fetch(apiUrlcust);
			if (!response1.ok) {
			throw new Error('Network response was not ok');
			}
			const data1 = await response1.json();
			//const cust_id = data1.customer_id;
			//console.log(cust_id);
            //const response2 = await fetch(`http://localhost:8085/VLC/resources/LoanService/customer/${cust_id}`);
            //if (!response2.ok) {
            //    throw new Error('Network response was not ok');
           // }
           // const data2 = await response2.json();
			populateDetailscustomers(data1);
			//const response3 = await fetch(`http://localhost:8085/VLC/resources/LoanService/vehicle/${cust_id}`);
			//if (!response3.ok) {
			//throw new Error('Network response was not ok');
			//}
			//const data3 = await response3.json();
          //  populateDetailsvehicles(data3);
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }

	function populateDetailscustomers(data1) {
	            document.getElementById('customer-name').textContent = data1.name || 'N/A';
	            document.getElementById('customer-email').textContent = data1.email_id || 'N/A';
	            document.getElementById('customer-phone').textContent = data1.mobile_number || 'N/A';
				document.getElementById('customer-age').textContent = data1.age || 'N/A';
				document.getElementById('customer-gender').textContent = data1.gender || 'N/A';
				document.getElementById('customer-employment').textContent = data1.type_of_employment || 'N/A';
				document.getElementById('customer-salary').textContent = data1.salary || 'N/A';
				document.getElementById('customer-emis').textContent = data1.existing_emis|| 'N/A';
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