package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue(200);

    public OrderManager() {
        Thread thread = new Thread() {
            @Override
            public void run() {
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    public void update(Observable tablet, Object arg) {
        Order order = (Order) arg;
        orderQueue.add(order);
    }
}
