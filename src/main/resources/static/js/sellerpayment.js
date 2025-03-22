let payments = [
    { seller_payment_id: 1, seller_id: 101, order_id: "ORD123", amount: 5000, status: "COMPLETED", method: "UPI", reference: "TXN789", created: "2025-03-22", updated: "2025-03-22" },
    { seller_payment_id: 2, seller_id: 102, order_id: "ORD124", amount: 3000, status: "PROCESSING", method: "BANK_TRANSFER", reference: "TXN790", created: "2025-03-21", updated: "2025-03-22" },
    { seller_payment_id: 3, seller_id: 103, order_id: "ORD125", amount: 7000, status: "PENDING", method: "CHEQUE", reference: "TXN791", created: "2025-03-20", updated: "2025-03-21" }
];

function loadPayments() {
    let table = document.getElementById("transactionTable");
    let totalEarnings = 0;
    let totalCommission = 0;
    
    payments.forEach(payment => {
        let commission = payment.amount * 0.10;
        let netAmount = payment.amount - commission;
        totalEarnings += payment.amount;
        totalCommission += commission;
        
        let row = `<tr>
            <td>${payment.seller_payment_id}</td>
            <td>${payment.seller_id}</td>
            <td>${payment.order_id}</td>
            <td>₹${payment.amount}</td>
            <td>${payment.status}</td>
            <td>${payment.method}</td>
            <td>${payment.reference || 'N/A'}</td>
            <td>${payment.created}</td>
            <td>${payment.updated}</td>
        </tr>`;
        table.innerHTML += row;
    });
    
    document.getElementById("totalEarnings").textContent = totalEarnings;
    document.getElementById("totalCommission").textContent = totalCommission.toFixed(2);
}

window.onload = loadPayments;