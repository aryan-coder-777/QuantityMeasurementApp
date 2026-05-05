package com.app.quantitymeasurement;

public class Quantity<U extends Unit> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.toBase(value);
        double converted = targetUnit.fromBase(base);
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);
        double sum = base1 + base2;
        double result = targetUnit.fromBase(sum);
        return new Quantity<>(result, targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity<?> that = (Quantity<?>) o;

        double base1 = this.unit.toBase(this.value);
        double base2 = that.unit.toBase(that.value);

        return Math.abs(base1 - base2) < 1e-6;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}