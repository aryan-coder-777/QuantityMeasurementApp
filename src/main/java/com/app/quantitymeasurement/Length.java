package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null || Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBaseUnit(value);
    }

    private double fromBase(double baseValue, LengthUnit targetUnit) {
        return targetUnit.fromBaseUnit(baseValue);
    }

    public Length convertTo(LengthUnit targetUnit) {
        double base = toBase();
        return new Length(fromBase(base, targetUnit), targetUnit);
    }

    public Length add(Length other, LengthUnit targetUnit) {

        double sumBase = this.toBase() + other.toBase();
        double result = fromBase(sumBase, targetUnit);

        return new Length(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        return Math.abs(this.toBase() - other.toBase()) < 0.0001;
    }
}