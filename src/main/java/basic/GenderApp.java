package basic;

import java.util.Arrays;

public class GenderApp {

    enum Gender {
        MAN, WOMAN, UNKNOWN
    }

    public static void main(String[] args) {
        System.out.println("Checking gender for Tommy");
        System.out.println("Tommy is: " + checkGender("Tommy"));

        System.out.println("Checking gender for Luisa");
        System.out.println("Luisa is: " + checkGender("Luisa"));

        System.out.println("Checking gender for Tinky-Win-ky");
        System.out.println("Tinky-Win-ky is: " + checkGender("Tinky-Win-ky"));
    }

    static Gender checkGender(String name) {
        String[] men = {"Steven", "Gery", "Tommy", "Jack"};
        String[] women = {"Angelina", "Maria", "Luisa", "Julia"};

        if (Arrays.stream(men).filter(s -> s.equals(name)).toArray().length > 0) {
            return Gender.MAN;
        } else if (Arrays.stream(women).filter(s -> s.equals(name)).toArray().length > 0) {
            return Gender.WOMAN;
        }

        return Gender.UNKNOWN;
    }
}
