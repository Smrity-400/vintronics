document.addEventListener("DOMContentLoaded", function () {
    const ordersContainer = document.getElementById("orders-container");

    // Sample Vintronics Retro Gadgets Order Data
    const orders = [
        {
            id: 1,
            productName: "Retro Gaming Console - Classic Edition",
            color: "Black & Red",
            price: "₹3,999",
            deliveryDate: "March 10, 2025",
            imageUrl: "https://via.placeholder.com/100",
            status: "Delivered",
            reviewAvailable: true
        },
        {
            id: 2,
            productName: "Vintage Polaroid Camera - 600 Series",
            color: "White & Blue",
            price: "₹5,499",
            deliveryDate: "March 5, 2025",
            imageUrl: "https://via.placeholder.com/100",
            status: "Delivered",
            reviewAvailable: true
        },
        {
            id: 3,
            productName: "Classic Walkman Cassette Player",
            color: "Silver & Black",
            price: "₹2,899",
            deliveryDate: "Feb 28, 2025",
            imageUrl: "https://via.placeholder.com/100",
            status: "Delivered",
            reviewAvailable: false
        }
    ];

    // Function to render orders dynamically
    function renderOrders() {
        ordersContainer.innerHTML = ""; // Clear previous orders
        orders.forEach(order => {
            const orderCard = document.createElement("div");
            orderCard.classList.add("order-card");

            let reviewLink = order.reviewAvailable
                ? `<a href="#" class="review-link">⭐ Rate & Review Product</a>`
                : "";

            orderCard.innerHTML = `
                <div class="order-content">
                    <img src="${order.imageUrl}" alt="Product Image">
                    <div class="order-details">
                        <h3>${order.productName}</h3>
                        <p>Color: ${order.color}</p>
                        <p class="order-price">${order.price}</p>
                    </div>
                    <div class="status">✔ Delivered on ${order.deliveryDate}</div>
                </div>
                ${reviewLink}
            `;
            ordersContainer.appendChild(orderCard);
        });
    }

    renderOrders(); // Initial rendering
});