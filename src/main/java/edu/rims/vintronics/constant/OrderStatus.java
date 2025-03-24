package edu.rims.vintronics.constant;

import edu.rims.vintronics.entity.Order;

public enum OrderStatus {
    PENDING, SHIPPED, DELIVERED, CANCELLED, CART;

    OrderStatus orElse(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElse'");
    }
}