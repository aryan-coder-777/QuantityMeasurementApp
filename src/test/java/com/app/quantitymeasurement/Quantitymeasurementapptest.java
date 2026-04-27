package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static QuantityWeight add(
            QuantityWeight w1,
            QuantityWeight w2,
            WeightUnit target) {

        return w1.add(w2, target);
    }

    public static QuantityWeight convert(
            QuantityWeight w,
            WeightUnit target) {

        return w.convertTo(target);
    }

    public static boolean compare(
            QuantityWeight w1,
            QuantityWeight w2) {

        return w1.equals(w2);
    }
}