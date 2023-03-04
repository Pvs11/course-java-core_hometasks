package homework.home_work_1.main.concurrency.censor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileQueue {
    BlockingQueue<File> files = new LinkedBlockingQueue<>();
    File resultFile;

    {
        try {
            resultFile = new File("src/homework.home_work_1.main.concurrency.main/concurrency/resultFile.txt");
            resultFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
