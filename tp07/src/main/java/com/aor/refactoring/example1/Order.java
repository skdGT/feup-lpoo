package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public double getTotal() {
        double total = 0;

        for (OrderLine line : this.lines)
            total += line.getLinePrice();

        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        return this.getTotal() > 100;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.details() + "\n");

        printBuffer.append("Total: " + this.getTotal());

        return printBuffer.toString();
    }
}