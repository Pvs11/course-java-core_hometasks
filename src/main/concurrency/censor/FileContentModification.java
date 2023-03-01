package main.concurrency.censor;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileContentModification implements Runnable {
    FileQueue fileQueue;
    File wordsFile;
    public FileContentModification(FileQueue fileQueue, File file) {
        this.fileQueue = fileQueue;
        this.wordsFile = file;
    }

    @Override
    public void run() {
        System.out.printf("%s has started word's removing\n", Thread.currentThread().getName());
        List<String> wordsToBeRemoved = null;
        try (BufferedReader br = new BufferedReader(new FileReader(wordsFile))) {
            wordsToBeRemoved = br.lines().flatMap(l -> Arrays.stream(l.split("\s"))).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File changedFile = new File("src/main/concurrency/" + fileQueue.resultFile.getName().replace(".txt", "Changed.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(fileQueue.resultFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(changedFile))) {
            changedFile.createNewFile();
            List<String> finalWordsToBeRemoved = wordsToBeRemoved;
            bw.write(br.lines().map(str -> {
                for (String s : finalWordsToBeRemoved) {
                    if (str.contains(s)) {
                        str = str.replaceAll(s, "");
                    }
                }
                return str + "\n";
            }).collect(Collectors.joining()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finished refactoring\n", Thread.currentThread().getName());
    }
}
