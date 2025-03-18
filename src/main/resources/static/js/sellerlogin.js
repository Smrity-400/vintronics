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

document.getElementById("sellerSignupForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let email = document.getElementById("signupEmail").value;
    let password = document.getElementById("signupPassword").value;
    let phone = document.getElementById("phone").value;
    let gst = document.getElementById("gst").value;
    let shopName = document.getElementById("shopName").value;
    let shopAddress = document.getElementById("shopAddress").value;

    if(email && password && phone && gst && shopName && shopAddress) {
        alert("Signup Successful!");
    } else {
        alert("Please fill out all fields.");
    }
});

document.getElementById("sellerLoginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if(email && password) {
        alert("Login Successful!");
    } else {
        alert("Please enter email and password.");
    }
});
