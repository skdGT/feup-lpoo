package com.skdgt.calculator;

import com.skdgt.calculator.shapes.HasArea;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
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
