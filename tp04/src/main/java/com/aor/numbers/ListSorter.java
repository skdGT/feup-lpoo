package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter {
    private final List<Integer> list;

    public ListSorter(List<Integer> list) {
        this.list = list;
    }

    /**
     * X-- Really stupid way to sort a list. --X
     * update: a better way to sort a list.
     * @return A sorted version of the list.
     */
    public List<Integer> sort() {
        List<Integer> sorted = new ArrayList();
        for (Integer number : list)
            sorted.add(number);

        Collections.sort(sorted);

        return sorted;
    }
}
