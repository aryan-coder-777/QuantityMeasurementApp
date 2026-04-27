package com.app.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantitytest {

    @Test
    void testEquality_SameValue() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);
        Quantity.Feet f2 = new Quantity.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);
        Quantity.Feet f2 = new Quantity.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}