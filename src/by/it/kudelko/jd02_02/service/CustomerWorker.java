package by.it.kudelko.jd02_02.service;

import by.it.kudelko.jd02_02.entity.Queue;
import by.it.kudelko.jd02_02.util.RandomGenerator;
import by.it.kudelko.jd02_02.util.Timer;
import by.it.kudelko.jd02_02.entity.Customer;
import by.it.kudelko.jd02_02.entity.Good;
import by.it.kudelko.jd02_02.entity.Shop;
import by.it.kudelko.jd02_02.interfaces.CustomerAction;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Shop shop;

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
        shop.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goToQueue();
        goOut();
        shop.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to " + shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeOut = RandomGenerator.get(500, 2000);
        Timer.sleep(timeOut);
        Good good = new Good();
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose goods");
        return good;
    }

    @Override
    public void goToQueue() {
        Queue queue = shop.getQueue();
        synchronized (customer.getMonitor()) {
            System.out.println(customer + " go to Queue");
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            System.out.println(customer + " leaves the Queue");
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the " + shop);
    }
}
