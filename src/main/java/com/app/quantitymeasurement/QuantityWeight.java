package com.apps.quantitymeasurement;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

        if (unit == null || Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toKg() {
        return unit.toBaseUnit(value);
    }

    private double fromKg(double kg, WeightUnit target) {
        return target.fromBaseUnit(kg);
    }

    public QuantityWeight convertTo(WeightUnit target) {
        return new QuantityWeight(fromKg(toKg(), target), target);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit target) {

        double sum = this.toKg() + other.toKg();
        return new QuantityWeight(fromKg(sum, target), target);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.toKg() - other.toKg()) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toKg());
    }
}