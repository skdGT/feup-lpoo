package com.skdgt.designpatterns.stringdrinks;

import java.util.List;

public class StringRecipe {
    List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix() {
        for (StringTransformer transformer : transformers)
            transformer.execute();
    }
}
