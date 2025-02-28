// Function to delete a category
// function deleteCategory(button) {
//     if (confirm("Are you sure you want to delete this category?")) {
//         let row = button.parentNode.parentNode;
//         row.parentNode.removeChild(row);
//     }
// }

// Function to edit a category
// function editCategory(button) {
//     let row = button.parentNode.parentNode;
//     let nameCell = row.cells[1];
//     let newName = prompt("Enter new category name:", nameCell.innerText);
//     if (newName !== null && newName.trim() !== "") {
//         nameCell.innerText = newName;
//     }
// }

// Open Modal
function openModal() {
    document.getElementById("categoryModal").style.display = "flex";
}

// Close Modal
function closeModal() {
    document.getElementById("categoryModal").style.display = "none";
}

// Add Category to Table
function addCategory() {
    let name = document.getElementById("categoryName").value;
    let desc = document.getElementById("categoryDesc").value;
    let price = document.getElementById("categoryPrice").value;
    let status = document.getElementById("categoryStatus").value;
    let image = document.getElementById("categoryImage").files[0]?.name || "No Image";

    if (!name || !price) {
        alert("Category Name and Price are required!");
        return;
    }

    let tableBody = document.getElementById("categoryTableBody");
    let newRow = document.createElement("tr");

    newRow.innerHTML = `
        <td>${name}</td>
        <td>${desc}</td>
        <td>${price}</td>
        <td>${status}</td>
        <td>${image}</td>
    `;

    tableBody.appendChild(newRow);
    closeModal();
}
