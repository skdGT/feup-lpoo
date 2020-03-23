package skdgt.designpatterns.stringdrinks;

import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    List<StringTransformer> transformerList;

    public StringTransformerGroup(List<StringTransformer> transformerList) {
        this.transformerList = transformerList;
    }

    @Override
    public void execute() {
        for (StringTransformer transformer : transformerList)
            transformer.execute();
    }

    @Override
    public void undo() {
        for (StringTransformer transformer : transformerList)
            transformer.undo();
    }
}
