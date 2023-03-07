package homework.home_work_2.main.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    private static String s = File.separator;

    public static void transferWithUpperCase(String inputFile, String outputFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, inputFile)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, outputFile)))) {
            bw.write(br.lines().map(String::toUpperCase).collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения/записи", e);
        }
    }

    public static List<String> readLines(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readWordsStartWithVowels(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().flatMap((str) -> Stream.of(str.split("[,.!?;\"':]?\\s")).filter(w -> w.matches("\\b[AaOoEeUuIiYy]\\w*"))).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readWordsWithSameStartEnd(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> words = br.lines().flatMap(line -> Stream.of(line.split("\\p{Punct}?\\s"))).toList();
            String word;
            for (int i = 0; i < words.size() - 1; i++) {
                if ((word = words.get(i)).endsWith(words.get(i + 1).substring(0, 1))) {
                    stringList.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }

    public static List<List<Integer>> findAscendingCombinations(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, path));
        List<List<Integer>> resultList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> list = Arrays.stream(line.split("\\s")).map(Integer::valueOf).toList();
                List<Integer> inter1 = new ArrayList<>();
                List<Integer> inter2 = new ArrayList<>();
                List<Integer> longestList = new ArrayList<>();
                for (int i = 0; i < list.size() - 1; i++) {
                    if (inter1.isEmpty()) {
                        while (i < list.size() - 1 && list.get(i) < list.get(i + 1)) {
                            inter1.add(list.get(i));
                            i++;
                        }
                        inter1.add(list.get(i));
                        if (inter1.size() > inter2.size()) {
                            longestList = inter1;
                        }
                        inter2 = new ArrayList<>();
                    } else {
                        while (i < list.size() - 1 && list.get(i) < list.get(i + 1)) {
                            inter2.add(list.get(i));
                            i++;
                        }
                        inter2.add(list.get(i));
                        if (inter1.size() < inter2.size()) {
                            longestList = inter2;
                        }
                        inter1 = new ArrayList<>();
                    }
                }
                resultList.add(longestList);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static Map<String, Integer> showLetterUsage(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", s, s, s, s, path));
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int c;
            String letter = "";
            while ((c = br.read()) != -1) {
                letter = Character.toString(c).toLowerCase();
                if (letter.matches("[a-z]")) {
                    if (resultMap.containsKey(letter)) {
                        resultMap.put(letter, resultMap.get(letter) + 1);
                    } else{
                        resultMap.put(letter, 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }
}
