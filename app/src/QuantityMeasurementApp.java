package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ================= LENGTH METHODS =================

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                      double v2, LengthUnit u2) {
        return new Length(v1, u1).equals(new Length(v2, u2));
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        return new Length(value, from).convertTo(to);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit to) {
        return length.convertTo(to);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit unit) {
        return l1.add(l2, unit);
    }


    // ================= WEIGHT METHODS (UC9) =================

    public static boolean demonstrateWeightEquality(QuantityWeight w1, QuantityWeight w2) {
        return w1.equals(w2);
    }

    public static boolean demonstrateWeightComparison(double v1, WeightUnit u1,
                                                      double v2, WeightUnit u2) {
        return new QuantityWeight(v1, u1).equals(new QuantityWeight(v2, u2));
    }

    public static QuantityWeight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
        return new QuantityWeight(value, from).convertTo(to);
    }

    public static QuantityWeight demonstrateWeightConversion(QuantityWeight weight, WeightUnit to) {
        return weight.convertTo(to);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight w1, QuantityWeight w2) {
        return w1.add(w2);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight w1, QuantityWeight w2, WeightUnit unit) {
        return w1.add(w2, unit);
    }


    // ================= MAIN (OPTIONAL DEMO) =================

    public static void main(String[] args) {

        // LENGTH DEMO
        System.out.println("Length:");
        System.out.println(new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES));
        System.out.println(new Length(1.0, LengthUnit.FEET)
                .add(new Length(12.0, LengthUnit.INCHES)));
        System.out.println(new Length(36.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.YARDS)));

        // WEIGHT DEMO
        System.out.println("\nWeight:");
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));

        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM)));

        System.out.println(new QuantityWeight(2.20462, WeightUnit.POUND)
                .convertTo(WeightUnit.KILOGRAM));
    }
}
