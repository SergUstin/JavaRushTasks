package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    private boolean processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty())
            return true;

        queue.offer(order);

        // setChanged();
        //notifyObservers(order);

        new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        return false;
    }

    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}
