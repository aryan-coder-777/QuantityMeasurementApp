package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void addFeetAndInchesToFeet() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.FEET);

        Length expected = new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addFeetAndInchesToInches() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.INCHES);

        Length expected = new Length(24.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addFeetAndInchesToYards() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.YARDS);

        Length expected = new Length(0.6667, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }
}