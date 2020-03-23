package com.skdgt.designpatterns.clients;

import com.skdgt.designpatterns.bar.BarObserver;
import com.skdgt.designpatterns.bar.StringBar;
import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public interface Client extends BarObserver {
    void wants(StringRecipe recipe, StringBar bar);
}
