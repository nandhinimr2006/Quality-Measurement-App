package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 1
        Length l1 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Input: Quantity(1.0, FEET).convertTo(INCHES) → Output: "
                + l1.convertTo(LengthUnit.INCHES));

        // 2
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, FEET).add(Quantity(12.0, INCHES), FEET) → Output: "
                + l1.add(l2, LengthUnit.FEET));

        // 3
        Length l3 = new Length(36.0, LengthUnit.INCHES);
        Length l4 = new Length(1.0, LengthUnit.YARDS);
        System.out.println("Input: Quantity(36.0, INCHES).equals(Quantity(1.0, YARDS)) → Output: "
                + l3.equals(l4));

        // 4
        Length l5 = new Length(1.0, LengthUnit.YARDS);
        Length l6 = new Length(3.0, LengthUnit.FEET);
        System.out.println("Input: Quantity(1.0, YARDS).add(Quantity(3.0, FEET), YARDS) → Output: "
                + l5.add(l6, LengthUnit.YARDS));

        // 5
        Length l7 = new Length(2.54, LengthUnit.CENTIMETERS);
        System.out.println("Input: Quantity(2.54, CENTIMETERS).convertTo(INCHES) → Output: "
                + l7.convertTo(LengthUnit.INCHES));

        // 6
        Length l8 = new Length(5.0, LengthUnit.FEET);
        Length l9 = new Length(0.0, LengthUnit.INCHES);
        System.out.println("Input: Quantity(5.0, FEET).add(Quantity(0.0, INCHES), FEET) → Output: "
                + l8.add(l9, LengthUnit.FEET));

        // 7
        System.out.println("Input: LengthUnit.FEET.convertToBaseUnit(12.0) → Output: "
                + LengthUnit.FEET.convertToBaseUnit(12.0));

        // 8
        System.out.println("Input: LengthUnit.INCHES.convertToBaseUnit(12.0) → Output: "
                + LengthUnit.INCHES.convertToBaseUnit(12.0));
    }
}
