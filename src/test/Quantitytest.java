package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetToInchesConversion() {

        Length l = new Length(1, LengthUnit.FEET);

        Length result =
                QuantityMeasurementApp.convert(l, LengthUnit.INCHES);

        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }

    @Test
    public void testAdditionFeetInchesToFeet() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.add(l1, l2, LengthUnit.FEET);

        assertEquals(new Length(2, LengthUnit.FEET), result);
    }

    @Test
    public void testAdditionFeetInchesToYards() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.add(l1, l2, LengthUnit.YARDS);

        assertTrue(result.equals(new Length(0.6667, LengthUnit.YARDS)));
    }
}