package com.app.quantitymeasurement;

public interface Unit {
    double toBase(double value);
    double fromBase(double baseValue);
}