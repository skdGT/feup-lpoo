package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ListFilterTest {
    private List<Integer> list;

    @Before
    public void setUp() {
        this.list = new ArrayList<>();
        this.list.add(2);
        this.list.add(1);
        this.list.add(-1);
        this.list.add(-2);
        this.list.add(6);
        this.list.add(4);
        this.list.add(0);
        this.list.add(3);
    }

    @Test
    public void filterPositive() {
        ListFilter listFilter = new ListFilter(list);
        IListFilter filter = new PositiveFilter();

        List<Integer> expected = new ArrayList<>();

        expected.add(2);
        expected.add(1);
        expected.add(6);
        expected.add(4);
        expected.add(3);

        List<Integer> filtered = listFilter.filter(filter);

        assertEquals(expected, filtered);
    }

    @Test
    public void filterDivisible() {
        ListFilter listFilter = new ListFilter(list);
        IListFilter filter = new DivisibleByFilter(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(-2);
        expected.add(6);
        expected.add(4);
        expected.add(0);

        List<Integer> filtered = listFilter.filter(filter);

        assertEquals(expected, filtered);
    }

    @Test
    public void filterDivisblePositive() {
        ListFilter listFilter = new ListFilter(list);
        IListFilter filterPositive = new PositiveFilter();
        IListFilter filterDivisible = new DivisibleByFilter(2);


        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(4);

        List<Integer> filtered = listFilter.filter(filterPositive);
        listFilter = new ListFilter(filtered);
        filtered = listFilter.filter(filterDivisible);
        assertEquals(expected, filtered);
    }
}
