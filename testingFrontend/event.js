
// Function to show the popup
function showPopup() {
    document.getElementById('popupForm').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
}

// Function to hide the popup
function closePopup() {
    document.getElementById('popupForm').style.display = 'none';
    document.getElementById('overlay').style.display = 'none';
}

// Initialize popup logic when the DOM is fully loaded
document.addEventListener('DOMContentLoaded', function() {
    // Check if the elements exist before adding event listeners
    const createEventButton = document.querySelector('.create-event');
    const overlay = document.getElementById('overlay');
    const closePopupButton = document.getElementById('closePopup');

    if (createEventButton) {
        createEventButton.addEventListener('click', showPopup);
    }

    if (overlay) {
        overlay.addEventListener('click', closePopup);
    }

    if (closePopupButton) {
        closePopupButton.addEventListener('click', closePopup);
    }
});



// // Function to show the popup
// function showPopup() {
//     document.getElementById('popupForm').style.display = 'block';
//     document.getElementById('overlay').style.display = 'block';
// }

// // Function to hide the popup
// function closePopup() {
//     document.getElementById('popupForm').style.display = 'none';
//     document.getElementById('overlay').style.display = 'none';
// }

// // Event listener for the Create Event button
// document.querySelector('.create-event').addEventListener('click', showPopup);

// // Event listener to close the popup when clicking outside the form
// document.getElementById('overlay').addEventListener('click', closePopup);

// // Event listener for the Close button inside the popup form
// document.getElementById('closePopup').addEventListener('click', closePopup);