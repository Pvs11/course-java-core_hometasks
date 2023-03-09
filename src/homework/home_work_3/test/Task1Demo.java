package homework.home_work_3.test;

import homework.home_work_3.main.Task1;

import java.util.List;
import java.util.Map;

import static homework.home_work_3.main.Task1.createListFromMap;
import static homework.home_work_3.main.Task1.createMapFromList;

public class Task1Demo {
    public static void main(String[] args) {
        List<String> stringList = List.of("-i", "in.txt", "--limit", "40", "-d", "1", "-o", "out.txt");
        Map<String, String> map = createMapFromList(stringList);

        System.out.println(createMapFromList(stringList));
        System.out.println(createListFromMap(map));
    }
}
