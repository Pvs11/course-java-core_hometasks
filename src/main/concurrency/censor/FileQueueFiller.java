package main.concurrency.censor;

import java.io.File;

public class FileQueueFiller implements Runnable {
    FileQueue fileQueue;
    File directory;

    public FileQueueFiller(FileQueue fileQueue, File directory) {
        this.fileQueue = fileQueue;
        this.directory = directory;
    }

    @Override
    public void run() {
        if (!directory.isDirectory()) {
            System.out.println("Such directory does not exist!");
            return;
        }
        for (File file : directory.listFiles()) {
            try {
                fileQueue.files.put(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
