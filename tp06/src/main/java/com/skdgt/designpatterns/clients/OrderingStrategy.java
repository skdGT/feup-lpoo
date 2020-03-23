package com.skdgt.designpatterns.clients;

import com.skdgt.designpatterns.bar.StringBar;
import com.skdgt.designpatterns.stringdrinks.StringRecipe;

public interface OrderingStrategy {
    void wants(StringRecipe recipe, StringBar bar);
    void happyHourStarted(StringBar bar);
    void happyHourEnded(StringBar bar);
}
