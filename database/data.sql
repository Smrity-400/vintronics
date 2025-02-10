INSERT INTO category (
    category_id, category_title, category_description, category_image_url, 
    category_status, created_date, updated_date, created_by, updated_by
) VALUES 
(UUID(), 'Computers', 'Computers and accesories', 'https://example.com/laptops.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
(UUID(), 'Rotary phones', 'Retro phones', 'https://example.com/smartphones.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
(UUID(), 'Cameras', 'Classic cameras', 'https://example.com/cameras.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
(UUID(), 'Gaming Consoles', ' gaming consoles and accessories', 'https://example.com/gaming.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),
(UUID(), 'Audio Devices', 'Headphones, speakers, and audio accessories', 'https://example.com/audio.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin');
