public class StringInverter implements StringTransformer {
    StringDrink stringDrink;

    public StringInverter(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    @Override
    public void execute() {
        StringBuffer stringBuffer = new StringBuffer(stringDrink.getText());
        stringDrink.setText(stringBuffer.reverse().toString());
    }

    @Override
    public void undo() {
        this.execute();
    }
}
