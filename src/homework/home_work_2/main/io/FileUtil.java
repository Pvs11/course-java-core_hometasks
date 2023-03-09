package homework.home_work_2.main.io;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    private static final Pattern wordsSplit = Pattern.compile("\\p{Punct}?\\s");
    private static final Pattern vowels = Pattern.compile("\\b[AaOoEeUuIiYy]\\w*");
    private static final Pattern space = Pattern.compile("\\s");
    private static final Pattern englishLetters = Pattern.compile("[a-z]");
    private static final String SEPARATOR = File.separator;

    public static void transferWithUpperCase(String inputFile, String outputFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, inputFile)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, outputFile)))) {
            bw.write(br.lines().map(String::toUpperCase).collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения/записи", e);
        }
    }

    public static List<String> readLines(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readWordsStartWithVowels(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().flatMap((str) -> Stream.of(str.split(wordsSplit.pattern())).filter(w -> w.matches(vowels.pattern()))).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readWordsWithSameStartEnd(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, path));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> words = br.lines().flatMap(line -> Stream.of(line.split(wordsSplit.pattern()))).toList();
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
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, path));
        List<List<Integer>> resultList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> list = Arrays.stream(line.split(space.pattern())).map(Integer::valueOf).toList();
                resultList.add(extractLongestAscendingSequence(list));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static Map<String, Integer> showLetterUsage(String path) {
        File file = new File(String.format("src%shomework%shome_work_2%sresources%s%s", SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, path));
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int c;
            String letter = "";
            while ((c = br.read()) != -1) {
                letter = Character.toString(c).toLowerCase();
                if (letter.matches(englishLetters.pattern())) {
                    resultMap.merge(letter, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }

    public static List<Integer> extractLongestAscendingSequence(List<Integer> listWhereToSearch) {
        List<Integer> intermediate1 = new ArrayList<>();
        List<Integer> intermediate2 = new ArrayList<>();
        List<Integer> longestList = new ArrayList<>();
        for (int i = 0; i < listWhereToSearch.size() - 1; i++) {
            if (intermediate1.isEmpty()) {
                while (i < listWhereToSearch.size() - 1 && listWhereToSearch.get(i) < listWhereToSearch.get(i + 1)) {
                    intermediate1.add(listWhereToSearch.get(i));
                    i++;
                }
                intermediate1.add(listWhereToSearch.get(i));
                if (intermediate1.size() > intermediate2.size()) {
                    longestList = intermediate1;
                }
                intermediate2 = new ArrayList<>();
            } else {
                while (i < listWhereToSearch.size() - 1 && listWhereToSearch.get(i) < listWhereToSearch.get(i + 1)) {
                    intermediate2.add(listWhereToSearch.get(i));
                    i++;
                }
                intermediate2.add(listWhereToSearch.get(i));
                if (intermediate1.size() < intermediate2.size()) {
                    longestList = intermediate2;
                }
                intermediate1 = new ArrayList<>();
            }
        }
        return longestList;
    }
}
