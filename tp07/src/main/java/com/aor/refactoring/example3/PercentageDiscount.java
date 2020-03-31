package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        return (percentage > 0) ? price - price * percentage : price;
    }
}
