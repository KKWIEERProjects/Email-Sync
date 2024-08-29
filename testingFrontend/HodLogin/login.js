document.querySelector('.login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const userId = document.getElementById('user-id').value;
    const password = document.getElementById('password').value;

    // Perform form validation or submit the form data
    console.log('User ID:', userId);
    console.log('Password:', password);
});




