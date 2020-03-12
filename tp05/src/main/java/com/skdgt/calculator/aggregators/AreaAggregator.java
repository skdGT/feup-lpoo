package com.skdgt.calculator.aggregators;

import com.skdgt.calculator.shapes.HasArea;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider {
    private List<HasArea> elements = new ArrayList<>();

    public void addShape(HasArea element) {
        elements.add(element);
    }

    public double sum() {
        double sum = 0;
        for (HasArea element: elements) {
            sum += element.getArea();
        }
        return sum;
    }
}
