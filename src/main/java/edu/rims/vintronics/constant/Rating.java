package edu.rims.vintronics.constant;

public enum Rating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    Rating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rating fromValue(int value) {
        for (Rating r : Rating.values()) {
            if (r.value == value) {
                return r;
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + value);
    }
}
