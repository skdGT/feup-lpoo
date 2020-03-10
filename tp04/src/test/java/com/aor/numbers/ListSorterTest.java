package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    private List<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
    }

    @Test
    public void sort() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);


        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        assertEquals(expected, sorted);
    }

    @Test
    public void bug1() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(4);

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(4);
        data.add(2);

        ListSorter sorted = new ListSorter(data);

        // this test failed so I know the problem is on the sort method
        assertEquals(expected, sorted.sort());
    }

}