package com.company;

import java.util.concurrent.CountDownLatch;

class JohnDailyWork implements Runnable
{

    private CountDownLatch latch;
    String nameOfWork;
    Thread t;
    int timeOfWork;

    public JohnDailyWork(String nameOfWork,int timeOfWork,CountDownLatch latch) {
        this.nameOfWork = nameOfWork;
        this.timeOfWork=timeOfWork;
        this.latch=latch;
        t=new Thread(this,nameOfWork);
        t.start();

    }

    @Override
    public void run() {
        System.out.println("John started "+ nameOfWork);
        try {
            Thread.sleep(timeOfWork);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nameOfWork+" is done");
        latch.countDown();
    }
}
class MargaretDailyWork implements Runnable
{
    private CountDownLatch latch;
    String nameOfWork;
    Thread t;
    int timeOfWork;

    public MargaretDailyWork(String nameOfWork,int timeOfWork,CountDownLatch latch) {
        this.nameOfWork = nameOfWork;
        this.timeOfWork=timeOfWork;
        this.latch=latch;
        t=new Thread(this,nameOfWork);
        t.start();

    }

    @Override
    public void run() {
        System.out.println("Matgaret started "+ nameOfWork);
        try {
            Thread.sleep(timeOfWork);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nameOfWork+" is done");
        latch.countDown();
    }
}



public class Main {

    public static void main(String[] args) {

        final  CountDownLatch latch = new CountDownLatch(6);
        JohnDailyWork johnDailyWork = new JohnDailyWork("Breakfast", 3000,latch);
        JohnDailyWork johnDailyWork1 = new JohnDailyWork("Bath", 1000,latch);
        JohnDailyWork johnDailyWork2 = new JohnDailyWork("Changing clothes", 2000,latch);
        MargaretDailyWork margaretDailyWork = new MargaretDailyWork("Running", 6000,latch);
        MargaretDailyWork margaretDailyWork1 = new MargaretDailyWork("Shower", 2000,latch);
        MargaretDailyWork margaretDailyWork2 = new MargaretDailyWork("Sleeping", 4000,latch);

        try {
            latch.await();
            System.out.println("Day is done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
            // write your code here
        }

         
    }
}


