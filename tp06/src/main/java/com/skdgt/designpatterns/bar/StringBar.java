package com.skdgt.designpatterns.bar;

import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public class StringBar extends Bar {
    public StringBar() {
        super();
    }

    public void order(StringRecipe recipe) {
        recipe.mix();
    }
}
