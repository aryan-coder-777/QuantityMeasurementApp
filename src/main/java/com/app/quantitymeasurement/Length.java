package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double toBase() {
        return Math.round(value * unit.getConversionFactor() * 100.0) / 100.0;
    }

    // Convert from base (inches) to target unit
    private double fromBase(double baseValue, LengthUnit targetUnit) {
        return Math.round((baseValue / targetUnit.getConversionFactor()) * 100.0) / 100.0;
    }

    // UC5 conversion
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double base = toBase();
        double converted = fromBase(base, targetUnit);
        return new Length(converted, targetUnit);
    }

    // ✅ UC6 ADD METHOD
    public Length add(Length that) {
        if (that == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double sumBase = this.toBase() + that.toBase();

        double result = fromBase(sumBase, this.unit);

        return new Length(result, this.unit);
    }

    // Equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;

        Length that = (Length) o;

        return Double.compare(this.toBase(), that.toBase()) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}