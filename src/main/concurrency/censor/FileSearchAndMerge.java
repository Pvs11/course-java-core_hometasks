package main.concurrency.censor;

import java.io.*;
import java.util.regex.Pattern;

public class FileSearchAndMerge implements Runnable {
    FileQueue fileQueue;
    Pattern pattern;

    public FileSearchAndMerge(FileQueue queue, String regex) {
        this.fileQueue = queue;
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started");
        while (fileQueue.files.peek() != null) {
            BufferedReader br = null;
            File currentFile = null;
            FileReader fr;
            try {
                currentFile = fileQueue.files.take();
                fr = new FileReader(currentFile);
                br = new BufferedReader(fr);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            if (br.lines().anyMatch(string -> string.contains(pattern.pattern()))) {
                try (FileReader fr2 = new FileReader(currentFile); BufferedReader br2 = new BufferedReader(fr2);
                     BufferedWriter bw = new BufferedWriter(new FileWriter(fileQueue.resultFile, true))) {
                    br2.transferTo(bw);
                    bw.append("\n--------\n");
                    System.out.printf("%s read file %s\n", Thread.currentThread().getName(), currentFile.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
