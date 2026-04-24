package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // ------------------- Equality Tests -------------------

    @Test
    public void testFeetEquality() {
        assertEquals(new Length(1.0, LengthUnit.FEET),
                new Length(1.0, LengthUnit.FEET));
    }

    @Test
    public void testFeetInchesEquality() {
        assertEquals(new Length(1.0, LengthUnit.FEET),
                new Length(12.0, LengthUnit.INCHES));
    }

    @Test
    public void testYardEqualsFeet() {
        assertEquals(new Length(1.0, LengthUnit.YARDS),
                new Length(3.0, LengthUnit.FEET));
    }

    @Test
    public void testCentimeterEqualsInch() {
        assertEquals(new Length(2.54, LengthUnit.CENTIMETERS),
                new Length(1.0, LengthUnit.INCHES));
    }

    @Test
    public void testInequality() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET),
                new Length(2.0, LengthUnit.FEET));
    }

    @Test
    public void testNullComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), null);
    }

    @Test
    public void testSameReference() {
        Length l = new Length(5.0, LengthUnit.FEET);
        assertEquals(l, l);
    }

    // ------------------- Conversion Tests -------------------

    @Test
    public void convertFeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertEquals(new Length(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void convertYardsToFeet() {
        Length result = new Length(1.0, LengthUnit.YARDS)
                .convertTo(LengthUnit.FEET);

        assertEquals(new Length(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void convertCmToInches() {
        Length result = new Length(2.54, LengthUnit.CENTIMETERS)
                .convertTo(LengthUnit.INCHES);

        assertEquals(new Length(1.0, LengthUnit.INCHES), result);
    }

    // ------------------- Addition Tests (UC6 + UC7) -------------------

    @Test
    public void addFeetAndInches_DefaultUnit() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES));

        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void addFeetAndInches_TargetInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(new Length(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void addFeetAndInches_TargetYards() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);

        assertEquals(new Length(0.67, LengthUnit.YARDS), result);
    }

    @Test
    public void addWithZero() {
        Length result = new Length(5.0, LengthUnit.FEET)
                .add(new Length(0.0, LengthUnit.INCHES), LengthUnit.FEET);

        assertEquals(new Length(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void addNegativeValues() {
        Length result = new Length(5.0, LengthUnit.FEET)
                .add(new Length(-2.0, LengthUnit.FEET), LengthUnit.INCHES);

        assertEquals(new Length(36.0, LengthUnit.INCHES), result);
    }

    @Test
    public void addCommutativity() {
        Length a = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);

        Length b = new Length(12.0, LengthUnit.INCHES)
                .add(new Length(1.0, LengthUnit.FEET), LengthUnit.YARDS);

        assertEquals(a, b);
    }

    @Test
    public void addNullTargetUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, LengthUnit.FEET)
                        .add(new Length(12.0, LengthUnit.INCHES), null)
        );
    }

    // ------------------- Validation Tests -------------------

    @Test
    public void invalidValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(Double.NaN, LengthUnit.FEET));
    }

    @Test
    public void nullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null));
    }
}
