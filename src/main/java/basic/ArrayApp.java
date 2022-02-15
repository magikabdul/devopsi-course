package basic;

public class ArrayApp {

    public static void main(String[] args) {
        int x;
        int[] array = {7, 14, 46, 13, 548, 2354, 333, 909, 667, 1};

        for (x = 0; x < 19; x++) {
            try {
                if (array[x] % 2 == 0) {
                    System.out.println("The number " + array[x] + " is even");
                } else {
                    System.out.println(array[x]);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index is larger than array size");
            }

        }
    }
}
