package com.skdgt.designpatterns.clients;

import com.skdgt.designpatterns.bar.StringBar;
import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public class ImpatientStrategy implements OrderingStrategy {
    StringRecipe recipe;

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        this.recipe = recipe;
        bar.order(recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        // do nothing
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        // do nothing
    }
}
