package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 🔹 LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);
        System.out.println("Length: " + l1.add(l2));

        // 🔹 WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        System.out.println("Weight: " + w1.add(w2));

        // 🔹 VOLUME (UC11)
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Add: " + v1.add(v2)); // 2 Litre

        // Convert
        System.out.println("Convert to Gallon: " +
                v1.convertTo(VolumeUnit.GALLON));

        // Explicit target unit
        System.out.println("Add in ML: " +
                v1.add(v2, VolumeUnit.MILLILITRE));
    }
}