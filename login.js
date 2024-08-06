document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        // You can add validation logic here if needed
        // Redirect to index.html upon successful login
        window.location.href = 'index.html';
    });
});
