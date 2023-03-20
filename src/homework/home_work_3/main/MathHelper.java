package homework.home_work_3.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MathHelper {
    public static int someNumber;

    public static List<Integer> generateArray(int elements) {
        List<Integer> list = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            list.add(new Random().nextInt(100));
        }
        return list;
    }

    public static boolean isEven(int number) {
        return Objects.equals(number % 2, 0);
    }

    public static boolean isOdd(int number) {
        return !Objects.equals(number % 2, 0);
    }

    public static boolean isZero(int number) {
        return Objects.equals(number, 0);
    }

    public static boolean isIdentical(int number) {
        return Objects.equals(someNumber, number);
    }

    public static int calculateOccurrences(List<Integer> list, MathOperation action) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (action.isEqual(list.get(i))) {
                count++;
            }
        }
        return count;
    }
}
