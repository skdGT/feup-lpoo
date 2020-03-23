import skdgt.designpatterns.stringdrinks.*;

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
