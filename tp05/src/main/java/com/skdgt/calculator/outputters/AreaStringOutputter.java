package com.skdgt.calculator.outputters;

import com.skdgt.calculator.aggregators.SumProvider;

public class AreaStringOutputter {
    private SumProvider sumProvider;

    public AreaStringOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "Sum of areas: " + sumProvider.sum();
    }
}
