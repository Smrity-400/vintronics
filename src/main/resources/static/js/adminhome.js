// Open "Add Category" Modal
function openModal() {
    document.getElementById("categoryModal").style.display = "flex";
}

// Close Any Modal
function closeModal(modalId) {
    document.getElementById(modalId).style.display = "none";
}

let editCategoryId = null;

// Open "Edit Category" Modal & Fill Data
function openEditModal(id, name, description, status) {
    editCategoryId = id;
    document.getElementById("editCategoryId").value = id; // Hidden field for ID
    document.getElementById("editCategoryInput").value = name;
    document.getElementById("editCategoryDesc").value = description;
    document.getElementById("editCategoryStatus").value = status;
    document.getElementById("editModal").style.display = "flex";
}

// Save Edited Category
function saveEdit() {
    let categoryId = document.getElementById("editCategoryId").value;
    let categoryName = document.getElementById("editCategoryInput").value;
    let categoryDesc = document.getElementById("editCategoryDesc").value;
    let categoryStatus = document.getElementById("editCategoryStatus").value;

    fetch(`/admin/edit-category`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            id: categoryId,
            categoryTitle: categoryName,
            categoryDescription: categoryDesc,
            categoryStatus: categoryStatus
        }),
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Category updated successfully!");
            location.reload();
        } else {
            alert("Error updating category.");
        }
    })
    .catch(error => console.error("Error:", error));
}

// Open "Delete Category" Modal
function openDeleteModal(id) {
    editCategoryId = id;
    document.getElementById("deleteModal").style.display = "flex";
}

// Confirm & Delete Category
function confirmDelete() {
    fetch(`/admin/delete-category/${editCategoryId}`, {
        method: "DELETE",
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Category deleted successfully!");
            location.reload();
        } else {
            alert("Error deleting category.");
        }
    })
    .catch(error => console.error("Error:", error));
}
