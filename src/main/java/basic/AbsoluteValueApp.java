package basic;

import java.util.Arrays;

public class AbsoluteValueApp {

    public static void main(String[] args) {
        double[] values = {-123.67, 234.5, 665.7, -0.43, -4.66};

        System.out.println("Initial table:" + Arrays.toString(values));
        System.out.println("Converted table:" + Arrays.toString(convertToPositive(values)));

    }

    static double[] convertToPositive(double[] table) {
        return Arrays.stream(table).map(Math::abs).toArray();
    }
}
