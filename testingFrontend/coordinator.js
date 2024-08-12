document.addEventListener('DOMContentLoaded', function() {
    const popupForm = document.getElementById('popupForm');
    
    if (popupForm) {
        const overlay = document.getElementById('overlay');
        const closePopup = document.getElementById('closePopup');

        function showPop() {
            overlay.style.display = 'block';
            popupForm.style.display = 'block';
        }

        function closePop() {
            overlay.style.display = 'none';
            popupForm.style.display = 'none';
        }

        closePopup.addEventListener('click', closePop);
        overlay.addEventListener('click', closePop);

        // Assuming you have a button to trigger the popup
        const createButton = document.querySelector('.create-event');
        if (createButton) {
            createButton.addEventListener('click', showPop);
        }
    }
});


// if (window.location.pathname === '/coordinator.html') {
//     // Load the JavaScript for the popup
//     var script = document.createElement('script');
//     script.src = 'coordinator.js';
//     document.head.appendChild(script);
// }