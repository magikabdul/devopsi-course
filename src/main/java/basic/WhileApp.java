package basic;

public class WhileApp {

    public static void main(String[] args) {
        int x = 0;
        int sum = 0;

        while (x <= 500) {
            sum += x;
            x++;
        }

        System.out.println("Sum of numbers from 1 to 500 equals: " + sum);
    }
}
