package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ================= LENGTH TESTS =================

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(12.0, LengthUnit.INCHES)
                .equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void yardEquals36Inches() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void convertFeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    public void addFeetAndInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES));

        assertTrue(result.equals(new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.01);
    }


    // ================= WEIGHT TESTS (UC9) =================

    @Test
    public void kilogramEquals1000Grams() {
        assertTrue(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));
    }

    @Test
    public void poundEquals453Point592Grams() {
        assertTrue(new QuantityWeight(1.0, WeightUnit.POUND)
                .equals(new QuantityWeight(453.592, WeightUnit.GRAM)));
    }

    @Test
    public void kilogramNotEqualToPound() {
        assertFalse(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1.0, WeightUnit.POUND)));
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertTrue(result.equals(new QuantityWeight(2.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void convertKilogramToGram() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    public void convertPoundToKilogram() {
        QuantityWeight result = new QuantityWeight(2.20462, WeightUnit.POUND)
                .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    public void addWithTargetUnit() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.01);
    }

    @Test
    public void zeroWeightEquality() {
        assertTrue(new QuantityWeight(0.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(0.0, WeightUnit.GRAM)));
    }

    @Test
    public void negativeWeight() {
        assertTrue(new QuantityWeight(-1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(-1000.0, WeightUnit.GRAM)));
    }
}
