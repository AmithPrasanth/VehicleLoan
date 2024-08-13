document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); 
        window.location.href = 'clientDashboard.html';
    });
    document.getElementById('admin').addEventListener('click', function(event) {
        event.preventDefault(); 
        window.location.href = 'adminDashboard.html'; 
    });
});
