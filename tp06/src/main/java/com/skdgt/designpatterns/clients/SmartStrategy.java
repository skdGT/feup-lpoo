package com.skdgt.designpatterns.clients;

import com.skdgt.designpatterns.bar.StringBar;
import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public class SmartStrategy implements OrderingStrategy {
    StringRecipe recipe;

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour())
            bar.order(recipe);

        this.recipe = recipe;
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        this.wants(recipe, bar);
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        // do nothing
    }
}
