package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    public void testKgEqualsGram() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    public void testConvertPoundToKg() {

        QuantityWeight w = new QuantityWeight(2.20462, WeightUnit.POUND);

        QuantityWeight result =
                QuantityMeasurementApp.convert(w, WeightUnit.KILOGRAM);

        assertTrue(result.equals(
                new QuantityWeight(1, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testAddKgAndGram() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight result =
                QuantityMeasurementApp.add(w1, w2, WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(2, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    public void testAddPoundAndKg() {

        QuantityWeight w1 = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight w2 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight result =
                QuantityMeasurementApp.add(w1, w2, WeightUnit.POUND);

        assertTrue(result.equals(
                new QuantityWeight(4.40924, WeightUnit.POUND)));
    }
}