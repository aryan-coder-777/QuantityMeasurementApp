package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum with conversion factors (base unit = inches)
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

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        double base = this.value * this.unit.getConversionFactor();
        return Math.round(base * 100.0) / 100.0;
    }

    // Compare
    private boolean compare(Length other) {
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length that = (Length) o;
        return compare(that);
    }

    // 🔥 UC5 Conversion Method (instance)
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = convertToBaseUnit();
        double converted = base / targetUnit.getConversionFactor();

        converted = Math.round(converted * 100.0) / 100.0;

        return new Length(converted, targetUnit);
    }

    // 🔥 UC5 Static Conversion API
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = value * from.getConversionFactor();
        return base / to.getConversionFactor();
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}