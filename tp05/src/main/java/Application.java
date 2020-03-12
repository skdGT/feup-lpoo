import com.skdgt.calculator.AreaAggregator;
import com.skdgt.calculator.AreaStringOutputter;
import com.skdgt.calculator.AreaXMLOutputter;
import com.skdgt.calculator.shapes.*;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addShape(new Square(10));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Square(3));
        aggregator.addShape(new Triangle(2,3));
        aggregator.addShape(new Ellipse(3, 5));
        aggregator.addShape(new House(20));

        // -- SRP ---
        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
        // ----------

    }
}
