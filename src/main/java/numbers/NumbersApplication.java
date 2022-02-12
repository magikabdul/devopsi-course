package numbers;

import java.util.Arrays;

public class NumbersApplication {

    public static void main(String[] args) {
        int[] values = {-1, 2, 50, 100};

        Numbers numbers = new Numbers(values);
        Lambda1 lambda1 = (int[] nums) ->  Arrays.stream(nums).sum();
        Lambda2 lambda2 = (int[] nums) -> (double) Arrays.stream(nums).sum() / nums.length;
        Lambda3 lambda3 = (int[] nums) -> Arrays.stream(nums).filter(value -> value > 2).forEach(System.out::println);

        System.out.println("Sum of array: " + numbers.add(lambda1));
        System.out.println("Average of array: " + numbers.avg(lambda2));
        numbers.show(lambda3);
    }
}
