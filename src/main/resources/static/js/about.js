document.addEventListener("DOMContentLoaded", function (){
const testimonials = [
    { text: "I love Vintronics products! The quality and service are outstanding. Highly recommend to everyone!", name: "Rahul Sharma", location: "Mumbai, India" },
    { text: "Fast delivery and excellent customer support. Vintronics never disappoints!", name: "Priya Verma", location: "Delhi, India" },
    { text: "Great deals and amazing products. I am a loyal Vintronics customer!", name: "Amit Joshi", location: "Bangalore, India" },
    { text: "Best shopping experience ever! Their retro gadgets collection is top-notch.", name: "Neha Kapoor", location: "Chennai, India" },
];

let currentIndex = 0;

function updateTestimonial() {
    document.getElementById("testimonial-text").textContent = testimonials[currentIndex].text;
    document.getElementById("customer-name").textContent = testimonials[currentIndex].name;
    document.getElementById("customer-location").textContent = testimonials[currentIndex].location;

    let dots = document.getElementsByClassName("dot");
    for (let i = 0; i < dots.length; i++) {
        dots[i].classList.remove("active");
    }
    dots[currentIndex].classList.add("active");
}

function prevTestimonial() {
    currentIndex = (currentIndex - 1 + testimonials.length) % testimonials.length;
    updateTestimonial();
}

function nextTestimonial() {
    currentIndex = (currentIndex + 1) % testimonials.length;
    updateTestimonial();
}

// Create dots dynamically
const dotsContainer = document.getElementById("dots");
testimonials.forEach((_, index) => {
    let dot = document.createElement("span");
    dot.classList.add("dot");
    if (index === 0) dot.classList.add("active");
    dot.addEventListener("click", () => {
        currentIndex = index;
        updateTestimonial();
    });
    dotsContainer.appendChild(dot);
});

// Initial call
updateTestimonial();
});