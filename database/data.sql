INSERT INTO category (
    category_id, category_title, category_description, category_image_url, 
    category_status, created_date, updated_date, created_by, updated_by
) VALUES 
('111e4567-e89b-12d3-a456-426614174000', 'Computers', 'Computers and accesories', 'https://example.com/laptops.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
('222e4567-e89b-12d3-a456-426614174001', 'Rotary phones', 'Retro phones', 'https://example.com/smartphones.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
('333e4567-e89b-12d3-a456-426614174002', 'Cameras', 'Classic cameras', 'https://example.com/cameras.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
('444e4567-e89b-12d3-a456-426614174003', 'Gaming Consoles', ' gaming consoles and accessories', 'https://example.com/gaming.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
('555e4567-e89b-12d3-a456-426614174004', 'Audio Devices', 'Headphones, speakers, and audio accessories', 'https://example.com/audio.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin');

INSERT INTO product (
    product_id, category_id, seller_id, product_title, product_description,
    product_price, product_stock_quantity, product_image_url, product_status,
    created_date, updated_date, created_by, updated_by
) VALUES
('aaa12345-e89b-12d3-a456-426614174000', '111e4567-e89b-12d3-a456-426614174000', 101, 'Gaming Laptop', 'High-performance gaming laptop with RTX 4080', 
 1499.99, 50, 'https://example.com/laptop.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174001', '222e4567-e89b-12d3-a456-426614174001', 102, 'Wireless Headphones', 'Noise-canceling wireless headphones', 
 199.99, 100, 'https://example.com/headphones.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174002', '333e4567-e89b-12d3-a456-426614174002', 103, 'Smartphone', 'Latest 5G smartphone with AI camera', 
 799.99, 200, 'https://example.com/smartphone.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174003', '444e4567-e89b-12d3-a456-426614174003', 104, 'Smartwatch', 'Fitness tracking smartwatch with heart rate monitor', 
 249.99, 80, 'https://example.com/smartwatch.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174004', '555e4567-e89b-12d3-a456-426614174004', 105, 'Bluetooth Speaker', 'Portable speaker with deep bass and 12-hour battery', 
 99.99, 150, 'https://example.com/speaker.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin');

INSERT INTO user (
    user_id, user_name, user_email, user_password, user_phone, user_address, user_role, 
    created_date, updated_date, created_by, updated_by
) VALUES 
(1,'John Doe', 'john.doe@example.com', 'hashed_password_123', '9876543210', '123 Main St, Mumbai', 'CUSTOMER', NOW(), NOW(), 'admin', 'admin'),
(2,'Alice Smith', 'alice.smith@example.com', 'hashed_password_456', '9988776655', '456 Elm St, Delhi', 'ADMIN', NOW(), NOW(), 'admin', 'admin'),
(3,'Rajesh Kumar', 'rajesh.kumar@example.com', 'hashed_password_789', '9123456789', '789 Oak St, Bangalore', 'SELLER', NOW(), NOW(), 'admin', 'admin'),
(4,'Meera Iyer', 'meera.iyer@example.com', 'hashed_password_321', '9456789012', '99 Brigade Rd, Hyderabad', 'ADMIN', NOW(), NOW(), 'admin', 'admin'),
(5,'Vikram Singh', 'vikram.singh@example.com', 'hashed_password_654', '9345678901', '55 MG Road, Chennai', 'SELLER', NOW(), NOW(), 'admin', 'admin'),
(6,'Priya Sharma', 'priya.sharma@example.com', 'hashed_password_987', '9234567890', '101 Park Ave, Kolkata', 'CUSTOMER', NOW(), NOW(), 'admin', 'admin');

INSERT INTO product_order (order_id, buyer_user_id, order_total_price, order_status, created_by, updated_by) 
VALUES 
(UUID(), 101, 1599.99, 'PENDING', 'admin', 'admin'),
(UUID(), 102, 899.50, 'SHIPPED', 'system', 'system'),
(UUID(), 103, 2500.75, 'DELIVERED', 'seller01', 'seller01'),
(UUID(), 104, 499.00, 'CANCELLED', 'buyer104', 'buyer104'),
(UUID(), 105, 3499.99, 'CART', 'guest', 'guest');
