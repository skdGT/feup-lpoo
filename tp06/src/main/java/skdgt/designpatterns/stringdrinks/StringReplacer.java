package skdgt.designpatterns.stringdrinks;

public class StringReplacer implements StringTransformer {
    StringDrink stringDrink;
    Character oldChar;
    Character newChar;

    public StringReplacer(StringDrink stringDrink, Character oldChar, Character newChar) {
        this.stringDrink = stringDrink;
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public void execute() {
        String change = stringDrink.getText();
        change = change.replace(this.oldChar, this.newChar);
        stringDrink.setText(change);
    }

    public void undo() {
        String change = stringDrink.getText();
        change = change.replace(this.newChar, this.oldChar);
        stringDrink.setText(change);
    }
}
