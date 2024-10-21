function showPopupAndSetUsername(popupId, hiddenFieldId, username) {
    // Show the popup
    document.getElementById(popupId).style.display = 'block';
    // Set the value of the hidden field to the username
    document.getElementById(hiddenFieldId).value = username;
}

// Function to close the popup
function closePopup(popupId) {
    document.getElementById(popupId).style.display = 'none';
}


function showPopup() {
    document.getElementById('popupForm').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
}
function showPopup12() {

    document.getElementById('popupForm12').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
}
// Function to hide the popup
function closePopup() {
    document.getElementById('popupForm').style.display = 'none';
    document.getElementById('overlay').style.display = 'none';
}
function closePopup12() {
    document.getElementById('popupForm12').style.display = 'none';
    document.getElementById('overlay').style.display = 'none';
}