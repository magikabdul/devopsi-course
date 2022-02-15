package basic;

import java.util.Arrays;

public class Grade {
    private final int[] grades;

    public Grade(int[] grades) {
        this.grades = grades;
    }

    public String averageScore() {
        double averageScore = Arrays.stream(grades).average().orElseThrow();
        char americanGrade = ' ';

        if (averageScore >= 4) {
            americanGrade = 'A';
            System.out.println("A = Super");
        } else if (averageScore >= 3) {
            americanGrade = 'B';
            System.out.println("B = Middling");
        } else if (averageScore < 3) {
            americanGrade = 'C';
            System.out.println("C = Poorly");
        }

        return switch (americanGrade) {
            case 'A' -> "A = Super";
            case 'B' -> "B = Middling";
            case 'C' -> "C = Poorly";

            default -> "Default - something were wrong";
        };
    }
}
