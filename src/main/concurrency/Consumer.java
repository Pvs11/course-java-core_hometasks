package main.concurrency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private boolean isActive;
    ShopQueue queue;

    public Consumer(ShopQueue queueToGet) {
        this.queue = queueToGet;
        this.isActive = true;
    }
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss");

    public void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            FileWriter fw = createFileWriter("E:/Git-projects/trash/course-java-core_hometasks/src/main/concurrency/goods/result.txt");
            if (queue.inputList.peek() != null) {
                int item = 0;
                try {
                    item = queue.inputList.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sleep(item);
                writeToFile(" - " + Thread.currentThread().getName() + " - " + "I slept " + item + " seconds\n", fw, dtf);
            } else {
                writeToFile(" - " + Thread.currentThread().getName() + "...\n", fw, dtf);
                sleep(1);
            }
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String text, FileWriter fw, DateTimeFormatter formatter) {
        try {
            fw.write(LocalDateTime.now().format(formatter) + text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileWriter createFileWriter(String path) {
        File resultFile = new File(path);
        FileWriter fw = null;
        try {
            resultFile.createNewFile();
            fw = new FileWriter(resultFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fw;
    }

}
