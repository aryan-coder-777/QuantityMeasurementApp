package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    // Generic comparison method
    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        boolean result = l1.equals(l2);
        System.out.println("Comparing (" + v1 + " " + u1 + ") and (" + v2 + " " + u2 + ") => " + result);
        return result;
    }

    public static void main(String[] args) {

        // Feet & Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yards & Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // Cm & Inches
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);

        // Feet & Yards
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        // Same unit
        demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS,
                2.0, Length.LengthUnit.YARDS);
    }
}