package main.concurrency;

import main.concurrency.exception.UserInputException;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
    private static final Logger logger = Logger.getLogger(Producer.class.getName());
    static FileHandler handler;

    static {
        try {
            handler = new FileHandler("E:/Git-projects/trash/course-java-core_hometasks/src/main/concurrency/log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(handler);
    }

    private ShopQueue queue;
    private boolean isActive;

    public Producer(ShopQueue queueToStore) {
        new Thread(this).start();
        this.isActive = true;
        this.queue = queueToStore;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            System.out.println("Please, write number you want to add to queue...");
            Scanner scan = new Scanner(System.in);
            String inputNumber = scan.next();
            try {
                if (inputNumber.matches("(-1)|(^[1-9]+[0-9]*$)")) {
                    if (Integer.parseInt(inputNumber) == -1) disable();

                    queue.inputList.offer(Integer.parseInt(inputNumber));
                } else {
                    throw new UserInputException("Input is not a number!");
                }
            } catch (UserInputException e) {
                logger.log(Level.WARNING, "Wrong input type!", e);
            }
        }
    }
}
