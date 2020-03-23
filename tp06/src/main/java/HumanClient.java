import skdgt.designpatterns.stringdrinks.*;

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
