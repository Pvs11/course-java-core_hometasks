package homework.home_work_2.test.io;

import static homework.home_work_2.main.io.FileUtil.*;

public class FileUtilDemo {

    public static void main(String[] args) {
        transferWithUpperCase("input.txt","output.txt");
        System.out.println(readLines("input.txt"));
        System.out.println(readWordsStartWithVowels("input.txt"));
        System.out.println(readWordsWithSameStartEnd("input.txt"));
        System.out.println(findAscendingCombinations("digits.txt"));
        System.out.println(showLetterUsage("input.txt"));
    }
}
