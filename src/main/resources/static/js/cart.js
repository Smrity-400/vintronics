document.querySelectorAll('.remove').forEach(button => {
    button.addEventListener('click', function() {
        this.closest('.cart-item').remove();
    });
});

document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".remove").forEach(button => {
        button.addEventListener("click", function () {
            this.closest(".cart-item").remove();
        });
    });

    document.querySelectorAll(".save-later").forEach(button => {
        button.addEventListener("click", function () {
            alert("Item saved for later!");
        });
    });
});

document.querySelectorAll('.increase').forEach(button => {
    button.addEventListener('click', function() {
        let input = this.previousElementSibling;
        let value = parseInt(input.value, 10);
        input.value = value + 1;
    });
});

document.querySelectorAll('.decrease').forEach(button => {
    button.addEventListener('click', function() {
        let input = this.nextElementSibling;
        let value = parseInt(input.value, 10);
        if (value > 1) {
            input.value = value - 1;
        }
    });
});