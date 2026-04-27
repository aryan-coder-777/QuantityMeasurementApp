package com.apps.quantitymeasurement;

public class Length {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInches;

        LengthUnit(double toInches) {
            this.toInches = toInches;
        }

        public double toBase() {
            return toInches;
        }
    }

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toInches() {
        return value * unit.toBase();
    }

    private double convertFromInches(double inches, LengthUnit target) {
        return inches / target.toBase();
    }

    // UC7 METHOD
    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Null not allowed");
        }

        double sumInches = this.toInches() + other.toInches();
        double result = convertFromInches(sumInches, targetUnit);

        return new Length(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Length)) return false;
        Length other = (Length) obj;

        return Math.abs(this.toInches() - other.toInches()) < 0.0001;
    }
}