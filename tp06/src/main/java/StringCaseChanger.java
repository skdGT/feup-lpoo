public class StringCaseChanger implements StringTransformer {
    StringDrink stringDrink;

    public StringCaseChanger(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = stringDrink.getText().toCharArray();

        for (Character a : chars) {
            if (Character.isLowerCase(a)) {
                stringBuilder.append(Character.toUpperCase(a));
            } else {
                stringBuilder.append(Character.toLowerCase(a));
            }
        }
        stringDrink.setText(stringBuilder.toString());
    }

    public void undo() {
        this.execute();
    }
}
