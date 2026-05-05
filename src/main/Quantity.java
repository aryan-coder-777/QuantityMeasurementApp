package com.app.quantitymeasurement;

import java.util.function.BiFunction;

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

    // 🔹 CENTRALIZED METHOD (UC13 CORE)
    private Quantity<U> operate(Quantity<U> other, U targetUnit,
                                BiFunction<Double, Double, Double> operation) {

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        double resultBase = operation.apply(base1, base2);

        double finalValue = targetUnit.fromBase(resultBase);
        return new Quantity<>(finalValue, targetUnit);
    }

    // 🔹 ADD
    public Quantity<U> add(Quantity<U> other) {
        return operate(other, this.unit, Double::sum);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        return operate(other, targetUnit, Double::sum);
    }

    // 🔹 SUBTRACT
    public Quantity<U> subtract(Quantity<U> other) {
        return operate(other, this.unit, (a, b) -> a - b);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        return operate(other, targetUnit, (a, b) -> a - b);
    }

    // 🔹 DIVIDE (Quantity / Quantity → double)
    public double divide(Quantity<U> other) {
        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        if (base2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return base1 / base2;
    }

    // 🔹 DIVIDE BY SCALAR
    public Quantity<U> divide(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return new Quantity<>(value / divisor, unit);
    }

    // 🔹 CONVERT
    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.toBase(value);
        double converted = targetUnit.fromBase(base);
        return new Quantity<>(converted, targetUnit);
    }

    // 🔹 EQUALS
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