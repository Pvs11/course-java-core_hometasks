package homework.home_work_1.test.concurrency;

import homework.home_work_1.main.concurrency.censor.FileContentModification;
import homework.home_work_1.main.concurrency.censor.FileQueue;
import homework.home_work_1.main.concurrency.censor.FileQueueFiller;
import homework.home_work_1.main.concurrency.censor.FileSearchAndMerge;

import java.io.*;
import java.util.Scanner;

public class FileSearchAndMergeDemo {

    public static void main(String[] args) throws InterruptedException {
        String exampleDirectory = "src/homework.home_work_1.main.concurrency.main/concurrency/exampleFiles";
        System.out.println("Please, specify directory where to search...");
        Scanner scan = new Scanner(System.in);

        File directory = new File(scan.next());
        FileQueue fileQueue = new FileQueue();
        FileQueueFiller fileQueueFiller = new FileQueueFiller(fileQueue, directory);
        FileSearchAndMerge searchAndMerge = new FileSearchAndMerge(fileQueue, "level");

        new Thread(fileQueueFiller).start();// Thread that add files in specified directory to FileQueue, in separate thread for convenience purpose
        new Thread(searchAndMerge).start();
        new Thread(searchAndMerge).start();
        new Thread(searchAndMerge).start();

        File file = new File("src/homework.home_work_1.main.concurrency.main/concurrency/censor/WordsToBeRemoved.txt");
        FileContentModification modification = new FileContentModification(fileQueue, file);
        new Thread(modification).start();
    }
}
