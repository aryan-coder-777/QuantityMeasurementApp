package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertTrue(result.equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testYardToFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                1.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);

        assertTrue(result.equals(new Length(3.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testCmToInches() {
        double result = Length.convert(2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testRoundTrip() {
        double v = 5.0;

        double converted = Length.convert(v,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        double back = Length.convert(converted,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(v, back, 0.01);
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(Double.NaN, Length.LengthUnit.FEET));
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null));
    }
}