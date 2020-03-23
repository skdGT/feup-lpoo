package com.skdgt.designpatterns.clients;

import com.skdgt.designpatterns.bar.Bar;
import com.skdgt.designpatterns.bar.StringBar;
import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public class HumanClient implements Client {
    OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void happyHourEnded(Bar bar) {
        // ---
    }

    @Override
    public void happyHourStarted(Bar bar) {
        this.strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        this.strategy.wants(recipe, bar);
    }
}
