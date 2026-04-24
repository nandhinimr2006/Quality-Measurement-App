package com.apps.quantitymeasurement;

public enum LengthUnit {

    // Base unit = FEET
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    // Convert this unit → feet (base)
    public double convertToBaseUnit(double value) {
        return value * toFeetFactor;
    }

    // Convert feet → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }
}
