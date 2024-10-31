
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


// Function to admin the menu
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active'); // Toggle the 'active' class
}

// Event listener to hide menu if clicking outside
window.addEventListener('click', function(event) {
    const menu = document.querySelector('.menu');
    const userButton = document.querySelector('.user');
    
    // Check if the click is outside the menu and the button
    if (!menu.contains(event.target) && !userButton.contains(event.target)) {
        // Remove the 'active' class to hide the menu
        menu.classList.remove('active');
    }
});


// function logic for notification

function toggleNotificationPopup() {
    const popup = document.querySelector('.notification-popup');
    const currentDisplay = popup.style.display;
    // Toggle display between block and none
    popup.style.display = (currentDisplay === 'block' || currentDisplay === '') ? 'none' : 'block';
}

// Optional: Close the popup if clicked outside
window.addEventListener('click', function(event) {
    const popup = document.querySelector('.notification-popup');
    const button = document.querySelector('.noti');

    // Check if the click is outside the popup and the button
    if (!button.contains(event.target) && !popup.contains(event.target)) {
        popup.style.display = 'none';
    }
});


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

//  current date and time function

function formatDate(date) {
    
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    const suffixes = ["th", "st", "nd", "rd"];
    
    // Get date components
    const day = date.getDate();
    const month = months[date.getMonth()];
    const year = date.getFullYear();
    
    const daySuffix = (day % 10 <= 3 && !(day >= 11 && day <= 13)) ? suffixes[day % 10] : suffixes[0];

    let hours = date.getHours();
    const minutes = date.getMinutes();
    const ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = hours ? hours : 12; 
    const formattedTime = `${hours}:${minutes < 10 ? '0' : ''}${minutes} ${ampm}`;

    return `${day}${daySuffix} ${month} ${year} | ${formattedTime}`;
}

const d = new Date();
const formattedDate = formatDate(d);

document.getElementById("demo").innerHTML = formattedDate;
document.getElementById("demo1").innerHTML = formattedDate;


