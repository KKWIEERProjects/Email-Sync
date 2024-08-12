document.querySelectorAll('.edit').forEach(button => {
    button.addEventListener('click', () => {
        alert('Edit functionality to be implemented.');
    });
});

document.querySelectorAll('.delete').forEach(button => {
    button.addEventListener('click', () => {
        if (confirm('Are you sure you want to delete this event?')) {
            button.closest('tr').remove();
        }
    });
});
