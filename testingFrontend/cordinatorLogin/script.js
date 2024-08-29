//navbar popup

// document.addEventListener('DOMContentLoaded', function() {
//     const popupForm = document.getElementById('popupForm');
    
//     if (popupForm) {
//         const overlay = document.getElementById('overlay');
//         const closePopup = document.getElementById('closePopup');

//         function showPop() {
//             overlay.style.display = 'block';
//             popupForm.style.display = 'block';
//         }

//         function closePop() {
//             overlay.style.display = 'none';
//             popupForm.style.display = 'none';
//         }

//         closePopup.addEventListener('click', closePop);
//         overlay.addEventListener('click', closePop);

//         // Assuming you have a button to trigger the popup
//         const createButton = document.querySelector('.create-event');
//         if (createButton) {
//             createButton.addEventListener('click', showPop);
//         }
//     }
// });


// if (window.location.pathname === '/coordinator.html') {
//     // Load the JavaScript for the popup
//     var script = document.createElement('script');
//     script.src = 'coordinator.js';
//     document.head.appendChild(script);
// }



function openTab(evt, tabName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Add event listeners for buttons
document.addEventListener('DOMContentLoaded', function () {
    var sendMailButtons = document.querySelectorAll('.send-mail-btn');
    sendMailButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            alert('Mail sent to ' + this.closest('tr').querySelector('td:nth-child(5)').textContent);
        });
    });

    var addGuestButton = document.querySelector('.add-guest-btn');
    addGuestButton.addEventListener('click', function () {
        alert('Add Guest functionality triggered!');
    });
});

