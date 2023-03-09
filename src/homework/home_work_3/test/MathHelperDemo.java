package homework.home_work_3.test;

import homework.home_work_3.main.MathHelper;

import java.util.List;

import static homework.home_work_3.main.MathHelper.calculateOccurrences;
import static homework.home_work_3.main.MathHelper.generateArray;

public class MathHelperDemo {

    public static void main(String[] args) {
        List<Integer> list = generateArray(40);
        System.out.println(list);
        MathHelper.someNumber = 55;

        System.out.println("Even: " + calculateOccurrences(list, MathHelper::isEven));
        System.out.println("Odd: " + calculateOccurrences(list, MathHelper::isOdd));
        System.out.println("Zero: " + calculateOccurrences(list, MathHelper::isZero));
        System.out.println("SomeNumber: " + calculateOccurrences(list, MathHelper::isIdentical));
    }
}
