package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison using values
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return demonstrateLengthEquality(l1, l2);
    }

    // 🔥 Conversion (method 1)
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        Length l = new Length(value, from);
        return l.convertTo(to);
    }

    // 🔥 Conversion (method 2 - overloaded)
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        return length.convertTo(to);
    }

    public static void main(String[] args) {

        // Equality
        System.out.println(demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES));

        // Conversion examples
        System.out.println(demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));

        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        System.out.println(demonstrateLengthConversion(l, Length.LengthUnit.INCHES));
    }
}