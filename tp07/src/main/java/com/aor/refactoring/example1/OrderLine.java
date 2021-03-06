package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getLinePrice() {
        return this.quantity * this.product.getPrice();
    }

    public String details() {
        return product.getName() + "(x" + quantity + "): " + (product.getPrice() * quantity);
    }
}
