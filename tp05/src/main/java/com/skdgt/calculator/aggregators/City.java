package com.skdgt.calculator.aggregators;

import com.skdgt.calculator.shapes.House;

import java.util.List;

public class City implements SumProvider {
    private List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public double sum() {
        double area = 0;
        for (House house : houses) {
            area += house.getArea();
        }
        return area;
    }
}
