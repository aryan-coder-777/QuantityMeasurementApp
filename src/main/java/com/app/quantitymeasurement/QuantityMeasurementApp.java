package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 🔹 LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Add Length: " + l1.add(l2));
        System.out.println("Subtract Length: " + l1.subtract(l2));

        // 🔹 WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(500.0, WeightUnit.GRAM);

        System.out.println("Add Weight: " + w1.add(w2));
        System.out.println("Divide Ratio: " + w1.divide(w2));
        System.out.println("Divide by 2: " + w1.divide(2));

        // 🔹 VOLUME
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Add Volume: " + v1.add(v2));
        System.out.println("Convert to Gallon: " + v1.convertTo(VolumeUnit.GALLON));
        System.out.println("Subtract Volume: " + v1.subtract(v2));
    }
}