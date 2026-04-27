package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static Length add(
            Length l1,
            Length l2,
            LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    public static Length convert(Length length, LengthUnit unit) {
        return length.convertTo(unit);
    }

    public static boolean compare(Length l1, Length l2) {
        return l1.equals(l2);
    }
}