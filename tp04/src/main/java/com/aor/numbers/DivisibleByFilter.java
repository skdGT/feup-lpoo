package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private int div;
    public DivisibleByFilter(Integer n) {
        this.div = n;
    }

    public boolean accept(Integer number) {
        return number % div == 0;
    }
}
