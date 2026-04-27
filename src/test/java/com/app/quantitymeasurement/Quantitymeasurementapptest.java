package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            Length.LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }
}