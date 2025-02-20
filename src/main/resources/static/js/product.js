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