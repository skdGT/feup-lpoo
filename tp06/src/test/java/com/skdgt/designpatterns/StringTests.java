package com.skdgt.designpatterns;

import com.skdgt.designpatterns.stringdrinks.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringTests {
    @Test
    public void stringDrink() {
        StringDrink drink = new StringDrink("ABCD");
        assertEquals("ABCD", drink.getText());
        drink.setText("DCBA");
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringInverter() {
        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter(drink);
        si.execute();
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringCaseChanger() {
        StringDrink drink = new StringDrink("aBcD");
        StringCaseChanger cc = new StringCaseChanger(drink);
        cc.execute();
        assertEquals("AbCd", drink.getText());
    }

    @Test
    public void stringReplacer() {
        StringDrink drink = new StringDrink("ABCDABCD");
        StringReplacer sr = new StringReplacer(drink, 'A', 'X');
        sr.execute();
        assertEquals("XBCDXBCD", drink.getText());
    }

    @Test
    public void stringRecipe() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");

        StringInverter si = new StringInverter(drink);
        StringCaseChanger cc = new StringCaseChanger(drink);
        StringReplacer sr = new StringReplacer(drink, 'A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        recipe.mix();

        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");

        StringInverter si = new StringInverter(drink);
        StringCaseChanger cc = new StringCaseChanger(drink);
        StringReplacer sr = new StringReplacer(drink, 'A', 'X');

        si.execute();
        cc.execute();
        sr.execute();

        sr.undo();
        assertEquals("dCbA-DcBa", drink.getText());

        cc.undo();
        assertEquals("DcBa-dCbA", drink.getText());

        si.undo();
        assertEquals("AbCd-aBcD", drink.getText());
    }
}
