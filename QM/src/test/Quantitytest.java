package com.app.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    // 🔹 Feet Tests

    @Test
    void testFeetEquality_SameValue() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);
        Quantity.Feet f2 = new Quantity.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);
        Quantity.Feet f2 = new Quantity.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testFeetEquality_NullComparison() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        Quantity.Feet f1 = new Quantity.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    // 🔹 Inches Tests

    @Test
    void testInchesEquality_SameValue() {
        Quantity.Inches i1 = new Quantity.Inches(1.0);
        Quantity.Inches i2 = new Quantity.Inches(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        Quantity.Inches i1 = new Quantity.Inches(1.0);
        Quantity.Inches i2 = new Quantity.Inches(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    void testInchesEquality_NullComparison() {
        Quantity.Inches i1 = new Quantity.Inches(1.0);

        assertFalse(i1.equals(null));
    }

    @Test
    void testInchesEquality_SameReference() {
        Quantity.Inches i1 = new Quantity.Inches(1.0);

        assertTrue(i1.equals(i1));
    }
}