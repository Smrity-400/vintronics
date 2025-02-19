use vintronics;

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
-- Retro Computers
('aaa12345-e89b-12d3-a456-426614174000', '111e4567-e89b-12d3-a456-426614174000', 101, 'Commodore 64', 'Classic 8-bit home computer from the 1980s', 
 299.99, 20, 'https://example.com/commodore64.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174005', '111e4567-e89b-12d3-a456-426614174000', 106, 'Apple II', 'Pioneering personal computer from Apple', 
 499.99, 15, 'https://example.com/appleii.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174006', '111e4567-e89b-12d3-a456-426614174000', 107, 'IBM PC 5150', 'The first IBM personal computer', 
 699.99, 10, 'https://example.com/ibmpc5150.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174007', '111e4567-e89b-12d3-a456-426614174000', 108, 'Atari 800', 'Popular 8-bit computer with gaming capabilities', 
 399.99, 12, 'https://example.com/atari800.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174008', '111e4567-e89b-12d3-a456-426614174000', 109, 'Tandy TRS-80', 'Early microcomputer sold by RadioShack', 
 349.99, 18, 'https://example.com/trs80.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174009', '111e4567-e89b-12d3-a456-426614174000', 110, 'Amiga 500', 'Advanced multimedia home computer', 
 549.99, 22, 'https://example.com/amiga500.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174010', '111e4567-e89b-12d3-a456-426614174000', 111, 'ZX Spectrum', 'Popular British 8-bit computer', 
 279.99, 25, 'https://example.com/zxspectrum.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('aaa12345-e89b-12d3-a456-426614174011', '111e4567-e89b-12d3-a456-426614174000', 112, 'NEC PC-98', 'Japanese PC with advanced graphics for its time', 
 599.99, 8, 'https://example.com/necpc98.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

-- Rotary Phones
('bbb12345-e89b-12d3-a456-426614174001', '222e4567-e89b-12d3-a456-426614174001', 102, 'Classic Rotary Phone', 'Vintage rotary dial phone with classic bell ringer', 
 149.99, 25, 'https://example.com/classic-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174002', '222e4567-e89b-12d3-a456-426614174001', 103, 'Retro Wall Phone', 'Antique wall-mounted rotary phone', 
 129.99, 20, 'https://example.com/retro-wall.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174003', '222e4567-e89b-12d3-a456-426614174001', 104, 'Cordless Rotary Phone', 'Retro design with modern cordless functionality', 
 199.99, 15, 'https://example.com/cordless-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174004', '222e4567-e89b-12d3-a456-426614174001', 105, '1940s Bakelite Phone', 'Authentic Bakelite rotary phone from the 1940s', 
 179.99, 10, 'https://example.com/bakelite.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174005', '222e4567-e89b-12d3-a456-426614174001', 106, 'Retro Office Phone', 'Classic rotary office desk phone', 
 159.99, 30, 'https://example.com/office-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174006', '222e4567-e89b-12d3-a456-426614174001', 107, 'Wooden Rotary Phone', 'Handcrafted wooden rotary phone with brass dial', 
 249.99, 12, 'https://example.com/wooden-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174007', '222e4567-e89b-12d3-a456-426614174001', 108, 'French Vintage Phone', 'Elegant French-style rotary phone with gold accents', 
 299.99, 8, 'https://example.com/french-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('bbb12345-e89b-12d3-a456-426614174008', '222e4567-e89b-12d3-a456-426614174001', 109, 'Deco Rotary Phone', 'Art deco inspired rotary phone from the 1930s', 
 199.99, 18, 'https://example.com/deco-rotary.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

-- cameras
('ccc12345-e89b-12d3-a456-426614174002', '333e4567-e89b-12d3-a456-426614174002', 201, 'Kodak Brownie', 'Classic Kodak Brownie camera from the 1950s', 
 299.99, 10, 'https://example.com/kodak-brownie.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174003', '333e4567-e89b-12d3-a456-426614174002', 202, 'Polaroid SX-70', 'Instant film camera with foldable design', 
 399.99, 15, 'https://example.com/polaroid-sx70.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174004', '333e4567-e89b-12d3-a456-426614174002', 203, 'Canon AE-1', '35mm film SLR camera with classic design', 
 499.99, 20, 'https://example.com/canon-ae1.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174005', '333e4567-e89b-12d3-a456-426614174002', 204, 'Nikon F', 'First professional Nikon SLR camera', 
 599.99, 12, 'https://example.com/nikon-f.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174006', '333e4567-e89b-12d3-a456-426614174002', 205, 'Leica M3', 'Legendary rangefinder camera from Leica', 
 1299.99, 8, 'https://example.com/leica-m3.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174007', '333e4567-e89b-12d3-a456-426614174002', 206, 'Yashica Mat-124', 'Twin-lens reflex medium format camera', 
 349.99, 14, 'https://example.com/yashica-mat124.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174008', '333e4567-e89b-12d3-a456-426614174002', 207, 'Hasselblad 500C', 'Medium format camera used in space missions', 
 1599.99, 5, 'https://example.com/hasselblad-500c.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ccc12345-e89b-12d3-a456-426614174009', '333e4567-e89b-12d3-a456-426614174002', 208, 'Olympus OM-1', 'Compact 35mm film SLR camera', 
 449.99, 18, 'https://example.com/olympus-om1.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

 -- Gaming Consoles
('ddd12345-e89b-12d3-a456-426614174003', '444e4567-e89b-12d3-a456-426614174003', 301, 'Atari 2600', 'Classic 8-bit gaming console from the late 70s', 
 199.99, 20, 'https://example.com/atari-2600.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174004', '444e4567-e89b-12d3-a456-426614174003', 302, 'Nintendo Entertainment System (NES)', 'Popular 8-bit gaming console from Nintendo', 
 249.99, 15, 'https://example.com/nes.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174005', '444e4567-e89b-12d3-a456-426614174003', 303, 'Super Nintendo (SNES)', '16-bit successor to the NES with improved graphics and sound', 
 299.99, 12, 'https://example.com/snes.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174006', '444e4567-e89b-12d3-a456-426614174003', 304, 'Sega Genesis', '16-bit gaming console known for Sonic the Hedgehog', 
 279.99, 10, 'https://example.com/sega-genesis.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174007', '444e4567-e89b-12d3-a456-426614174003', 305, 'PlayStation 1', 'First PlayStation console with CD-based games', 
 349.99, 18, 'https://example.com/playstation1.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174008', '444e4567-e89b-12d3-a456-426614174003', 306, 'Nintendo 64', 'First Nintendo console with 3D gaming capabilities', 
 399.99, 14, 'https://example.com/nintendo64.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174009', '444e4567-e89b-12d3-a456-426614174003', 307, 'Sega Dreamcast', 'Last console by Sega with innovative online gaming', 
 329.99, 8, 'https://example.com/dreamcast.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

('ddd12345-e89b-12d3-a456-426614174010', '444e4567-e89b-12d3-a456-426614174003', 308, 'Game Boy Color', 'Handheld console with color screen from Nintendo', 
 179.99, 25, 'https://example.com/gameboy-color.jpg', 'ACTIVE', NOW(), NOW(), 'admin', 'admin'),

-- Audio Devices
('eee12345-e89b-12d3-a456-426614174004', '555e4567-e89b-12d3-a456-426614174004', 401, 'Sony Walkman', 'Classic portable cassette player from Sony', 
 149.99, 20, 'https://example.com/sony-walkman.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174005', '555e4567-e89b-12d3-a456-426614174004', 402, 'Bose 901 Speakers', 'High-fidelity speakers with deep bass and clear sound', 
 499.99, 10, 'https://example.com/bose-901.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174006', '555e4567-e89b-12d3-a456-426614174004', 403, 'Technics SL-1200', 'Classic direct-drive turntable for vinyl records', 
 899.99, 8, 'https://example.com/technics-sl1200.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174007', '555e4567-e89b-12d3-a456-426614174004', 404, 'iPod Classic', 'Iconic Apple iPod with high storage capacity', 
 299.99, 15, 'https://example.com/ipod-classic.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174008', '555e4567-e89b-12d3-a456-426614174004', 405, 'JBL L100 Speakers', 'Retro-styled bookshelf speakers with powerful sound', 
 699.99, 12, 'https://example.com/jbl-l100.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174009', '555e4567-e89b-12d3-a456-426614174004', 406, 'Sennheiser HD 414', 'First open-back headphones with unique sound quality', 
 199.99, 18, 'https://example.com/sennheiser-hd414.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174010', '555e4567-e89b-12d3-a456-426614174004', 407, 'Akai GX-747', 'Classic reel-to-reel tape recorder for high-quality audio recording', 
 1299.99, 5, 'https://example.com/akai-gx747.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin'),

('eee12345-e89b-12d3-a456-426614174011', '555e4567-e89b-12d3-a456-426614174004', 408, 'Marshall Stanmore', 'Retro Bluetooth speaker with vintage design', 
 349.99, 22, 'https://example.com/marshall-stanmore.jpg', 'INACTIVE', NOW(), NOW(), 'admin', 'admin');


INSERT INTO user (
    user_id, user_name, user_email, user_password, user_phone, user_address, user_role, 
    created_date, updated_date, created_by, updated_by
) VALUES 
(101,'John Doe', 'john.doe@example.com', 'hashed_password_123', '9876543210', '123 Main St, Mumbai', 'CUSTOMER', NOW(), NOW(), 'admin', 'admin'),
(102,'Alice Smith', 'alice.smith@example.com', 'hashed_password_456', '9988776655', '456 Elm St, Delhi', 'ADMIN', NOW(), NOW(), 'admin', 'admin'),
(103,'Rajesh Kumar', 'rajesh.kumar@example.com', 'hashed_password_789', '9123456789', '789 Oak St, Bangalore', 'SELLER', NOW(), NOW(), 'admin', 'admin'),
(104,'Meera Iyer', 'meera.iyer@example.com', 'hashed_password_321', '9456789012', '99 Brigade Rd, Hyderabad', 'ADMIN', NOW(), NOW(), 'admin', 'admin'),
(105,'Vikram Singh', 'vikram.singh@example.com', 'hashed_password_654', '9345678901', '55 MG Road, Chennai', 'SELLER', NOW(), NOW(), 'admin', 'admin'),
(106,'Priya Sharma', 'priya.sharma@example.com', 'hashed_password_987', '9234567890', '101 Park Ave, Kolkata', 'CUSTOMER', NOW(), NOW(), 'admin', 'admin');

INSERT INTO product_order (
    order_id, buyer_user_id, order_total_price, order_status, 
    created_by, created_date, updated_by, updated_date
) 
VALUES 
    (UUID(), 101, 1599.99, 'PENDING', 'admin', NOW(6), 'admin', NOW(6)),
    (UUID(), 102, 899.50, 'SHIPPED', 'system', NOW(6), 'system', NOW(6)),
    (UUID(), 103, 2500.75, 'DELIVERED', 'seller01', NOW(6), 'seller01', NOW(6)),
    (UUID(), 104, 499.00, 'CANCELLED', 'buyer104', NOW(6), 'buyer104', NOW(6)),
    (UUID(), 105, 3499.99, 'CART', 'guest', NOW(6), 'guest', NOW(6));

