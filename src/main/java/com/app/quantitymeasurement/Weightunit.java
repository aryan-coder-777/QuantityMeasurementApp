package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKg;

    WeightUnit(double toKg) {
        this.toKg = toKg;
    }

    public double toBaseUnit(double value) {
        return value * toKg;
    }

    public double fromBaseUnit(double kgValue) {
        return kgValue / toKg;
    }
}