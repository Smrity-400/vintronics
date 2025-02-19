window.addEventListener("scroll", () => {
  const navbar = document.querySelector("header");
  if (window.scrollY > 10) {
    navbar.style.background = "black";
    navbar.style.position = "sticky";
  } else {
    navbar.style.background = "transparent";
    navbar.style.position = "absolute";
  }
});

// Select elements
const hamburger = document.getElementById('hamburger');
const sidePanel = document.getElementById('sidePanel');

// Toggle the side panel
hamburger.addEventListener('click', () => {
  sidePanel.classList.toggle('open');
});
document.addEventListener('click', (event) => {
  if (sidePanel.classList.contains('open') &&
  !sidePanel.contains(event.target) &&
  !hamburger.contains(event.target)) {
    sidePanel.classList.remove('open');
  }
});
// JavaScript for Carousel Functionality
const carousel = document.getElementById('carousel');
const slides = carousel.children;
const prevButton = document.getElementById('prev');
const nextButton = document.getElementById('next');
let currentIndex = 0;

function showSlide(index) {
  const offset = -index * 100;
  carousel.style.transform = `translateX(${offset}%)`;
}

prevButton.addEventListener('click', () => {
  currentIndex = (currentIndex > 0) ? currentIndex - 1 : slides.length - 1;
  showSlide(currentIndex);
});

nextButton.addEventListener('click', () => {
  currentIndex = (currentIndex < slides.length - 1) ? currentIndex + 1 : 0;
  showSlide(currentIndex);
});

// Initialize the first slide
showSlide(currentIndex);