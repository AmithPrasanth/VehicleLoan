document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'http://localhost:8085/VLC/resources/LoanService/customers/'; // Replace with your API URL
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
        const tableBody = document.querySelector('#data-table tbody');
        tableBody.innerHTML = ''; // Clear existing table rows
        data.forEach(item => {
            const row = document.createElement('tr');
            const nameCell = document.createElement('td');
            nameCell.textContent = item.name;
            row.appendChild(nameCell);
            const custIdCell = document.createElement('td');
            custIdCell.textContent = item.customer_id;
            row.appendChild(custIdCell);
            const numberCell = document.createElement('td');
            numberCell.textContent = item.mobile_number;
            row.appendChild(numberCell);
            const emailCell = document.createElement('td');
            emailCell.textContent = item.email_id;
            row.appendChild(emailCell);
            const actionsCell = document.createElement('td');
            const viewDetailsButton = document.createElement('button');
            viewDetailsButton.textContent = 'View Details';
            viewDetailsButton.addEventListener('click', () => {
                // Handle the view details button click
                alert(`Viewing details for ${item.name}`);
            });
            actionsCell.appendChild(viewDetailsButton);
            row.appendChild(actionsCell);
            tableBody.appendChild(row);
        });
    }
    // Fetch and display data when the page loads
    fetchData();
});