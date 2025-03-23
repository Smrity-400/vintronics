document.getElementById("showSignup").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("loginContainer").style.display = "none";
    document.getElementById("signupContainer").style.display = "block";
});

document.getElementById("showLogin").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("signupContainer").style.display = "none";
    document.getElementById("loginContainer").style.display = "block";
});
