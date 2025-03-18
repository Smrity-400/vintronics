// Open Modal
function openModal() {
    document.getElementById("categoryModal").style.display = "flex";
}

// Close Modal
function closeModal() {
    document.getElementById("categoryModal").style.display = "flex";
}

let editCategoryId = null;
function openEditModal(id, name) {
    editCategoryId = id;
    document.getElementById('editCategoryInput').value = name;
    document.getElementById('editModal').style.display = 'flex';
}

function saveEdit() {
    alert('Category updated successfully!');
    closeModal('editModal');
}

function openDeleteModal(id) {
    editCategoryId = id;
    document.getElementById('deleteModal').style.display = 'flex';
}

function confirmDelete() {
    alert('Category deleted successfully!');
    closeModal('deleteModal');
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'flex';
}