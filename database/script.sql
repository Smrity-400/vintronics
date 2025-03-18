CREATE SCHEMA vintronics;

USE vintronics;

CREATE TABLE category (
    category_id  VARCHAR(255) PRIMARY KEY ,  
    category_title VARCHAR(255) NOT NULL,                   
    category_description TEXT NULL,                             
    category_image_url TEXT NOT NULL,                          
    category_status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP, 
    updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255) 
);

CREATE TABLE product (
    product_id VARCHAR(255) PRIMARY KEY,  
    category_id VARCHAR(255) ,  
    seller_id INT NOT NULL,   
    product_title VARCHAR(255) NOT NULL,  
    product_description TEXT NULL,  
    product_price DOUBLE NOT NULL CHECK (product_price >= 0), 
    product_stock_quantity INT NOT NULL CHECK (product_stock_quantity >= 0),  
    product_image_url TEXT NOT NULL,  
    product_status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',  
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,  
    updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE SET NULL,
    CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES user(user_id) ON DELETE CASCADE
);



CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_phone VARCHAR(20),
    user_address TEXT,
    user_role ENUM('CUSTOMER', 'ADMIN', 'SELLER') DEFAULT 'CUSTOMER',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,  
    updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
);

CREATE TABLE product_order (
    order_id VARCHAR(255) PRIMARY KEY,
    buyer_user_id INT NOT NULL,
    order_total_price DECIMAL(10,2) NOT NULL,
    order_status ENUM('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED', 'CART') DEFAULT 'PENDING',
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_user FOREIGN KEY (buyer_user_id) REFERENCES user(user_id) ON DELETE CASCADE
);


CREATE TABLE order_item (
    order_item_id VARCHAR(255) PRIMARY KEY,
    order_id VARCHAR(255) PRIMARY KEY,
    product_id VARCHAR(255) PRIMARY KEY,
    order_item_quantity INT NOT NULL DEFAULT 0,
    order_item_unit_price DECIMAL(10,2) NOT NULL,
    order_item_total_price DECIMAL(10,2) NOT NULL,
    order_item_status ENUM('ADDED', 'REMOVED') DEFAULT 'ADDED',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES order(order_id) ON DELETE CASCADE,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE
);

CREATE TABLE review(
    review_id VARCHAR(255) PRIMARY KEY ,
    user_id INT NOT NULL,
    product_id VARCHAR(255) PRIMARY KEY,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE
);

CREATE TABLE wishlist (
    wishlist_id VARCHAR(255) PRIMARY KEY ,
    user_id INT NOT NULL,
    product_id VARCHAR(255) PRIMARY KEY,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_wishlist_user FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_wishlist_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE
);

CREATE TABLE payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(255) PRIMARY KEY,
    payment_method ENUM('CREDIT_CARD', 'DEBIT_CARD', 'PAYPAL', 'UPI', 'COD') NOT NULL,
    payment_status ENUM('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'PENDING',
    transaction_id VARCHAR(255) UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_-date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_payment_order FOREIGN KEY (order_id) REFERENCES order(order_id) ON DELETE CASCADE
);

CREATE TABLE seller_payment (
    seller_payment_id INT AUTO_INCREMENT PRIMARY KEY,
    seller_id INT NOT NULL,
    order_id VARCHAR(255) PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    seller_payment_status ENUM('PENDING', 'PROCESSING', 'COMPLETED', 'FAILED') NOT NULL DEFAULT 'PENDING',
    seller_payment_method ENUM('BANK_TRANSFER', 'UPI', 'CHEQUE', 'OTHER') NOT NULL,
    transaction_reference VARCHAR(255) NULL UNIQUE, 
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_seller_order FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

CREATE TABLE seller (
    seller_id INT AUTO_INCREMENT PRIMARY KEY,
    seller_name VARCHAR(100) NOT NULL,
    seller_store_name VARCHAR(100) NOT NULL,
    seller_email VARCHAR(100) UNIQUE NOT NULL,
    seller_phone VARCHAR(15) NOT NULL,
    gst_no VARCHAR(15) UNIQUE NOT NULL,
    address TEXT NOT NULL,
    total_products INT DEFAULT 0,
    seller_status ENUM('Active', 'Inactive') DEFAULT 'Active',
    commission_percentage DECIMAL(5,2) DEFAULT 5.00,
    seller_bank_account_number VARCHAR(20) UNIQUE NOT NULL,
    seller_ifsc_code VARCHAR(11) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_seller_user FOREIGN KEY (seller_id) REFERENCES user(user_id) ON DELETE CASCADE
);
