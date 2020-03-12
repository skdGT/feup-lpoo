public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addShape(new Square(10));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Square(3));

        System.out.println(aggregator.output());
    }
}
