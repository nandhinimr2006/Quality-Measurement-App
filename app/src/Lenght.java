package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.01;

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value or unit");
        }
        this.value = value;
        this.unit = unit;
    }

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInches;

        LengthUnit(double toInches) {
            this.toInches = toInches;
        }
    }

    // Convert to inches (base unit)
    private double toBase() {
        return this.value * this.unit.toInches;
    }

    // Convert from inches to target unit
    private static double fromBase(double inches, LengthUnit targetUnit) {
        return round(inches / targetUnit.toInches);
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // UC5
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit null");

        double base = toBase();
        double converted = fromBase(base, targetUnit);
        return new Length(converted, targetUnit);
    }

    // UC6 (same as before)
    public Length add(Length that) {
        return add(that, this.unit);
    }

    // ✅ UC7: Add with target unit
    public Length add(Length that, LengthUnit targetUnit) {
        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumInBase = this.toBase() + that.toBase();
        double result = fromBase(sumInBase, targetUnit);

        return new Length(result, targetUnit);
    }

    // Equality check (based on inches)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;

        Length that = (Length) o;
        return Math.abs(this.toBase() - that.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round(toBase()));
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
