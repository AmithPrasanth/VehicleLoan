function calculateEMI() {
    const amount = parseFloat(document.getElementById('amount').value);
    const tenure = parseInt(document.getElementById('tenure').value);
    const interestRate = parseFloat(document.getElementById('interest').value);
    const existingEmis = parseFloat(document.getElementById('existingEmis').value) || 0;

    if (isNaN(amount) || isNaN(tenure) || isNaN(interestRate) || amount <= 0 || tenure <= 0 || interestRate <= 0) {
        document.getElementById('result').innerHTML = 'Please enter valid positive numbers for all fields.';
        return;
    }

    const monthlyInterestRate = (interestRate / 100) / 12;

    const emi = (amount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure)) / 
                (Math.pow(1 + monthlyInterestRate, tenure) - 1);

    const totalEmi = emi + existingEmis;
    const totalAmountPaid = emi * tenure;

    document.getElementById('result').innerHTML = `
        Your new EMI is ₹${emi.toFixed(2)}<br>
        Total EMI (including existing EMIs) is ₹${totalEmi.toFixed(2)}<br>
        Total amount to be paid over the loan term is ₹${totalAmountPaid.toFixed(2)}
    `;
}
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