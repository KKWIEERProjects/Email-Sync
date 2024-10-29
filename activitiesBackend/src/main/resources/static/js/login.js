var toast = document.getElementById("toast");
    if (toast) {
        toast.classList.add("show");
        setTimeout(function(){ toast.classList.remove("show"); }, 3000); // Hide after 3 seconds
    }