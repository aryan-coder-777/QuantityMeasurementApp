package com.app.quantitymeasurement;

public enum VolumeUnit implements Unit {

    LITRE(1.0),          // Base unit
    MILLILITRE(0.001),  // 1 ml = 0.001 L
    GALLON(3.78541);    // 1 gallon ≈ 3.78541 L

    private final double factor;

    VolumeUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double toBase(double value) {
        return value * factor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }
}