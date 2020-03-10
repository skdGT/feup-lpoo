package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    List<Integer> list;

    @Before
    public void setUp() {
        this.list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }


    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        // We use stubs so that we dont have to bother about the
        // rest of the code, as if we know that one piece of code
        // has dependencies to another piece of code (class)
        // but we want to test if a function is working if the info it
        // gets is valid (i.g.?)

        // using JUnit stubs
        class StubList implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        // using Mockito stubs
        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate()).thenReturn(deduplicated);

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }

    @Test   // Bug #7263
    public void bug1() {
        List<Integer> test = new ArrayList<>();

        test.add(-1);
        test.add(-4);
        test.add(-5);

        ListAggregator aggregator = new ListAggregator(test);

        int maximum = aggregator.max();

        assertEquals(-1, maximum);
    }

    @Test   // Bug #8726
    public void bug2() {
        List<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(4);
        test.add(2);

        ListAggregator aggregator = new ListAggregator(test);

        int distinct = aggregator.distinct(new ListDeduplicator(test));

        // this will fail
        // created a test on ListSorterTest to check whether the sort() method
        // was failing
        assertEquals(3, distinct);
    }


}