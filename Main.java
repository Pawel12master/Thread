package com.company;


import java.util.concurrent.CountDownLatch;

class NewThread implements Runnable
{
    private CountDownLatch latch;
   public NewThread(CountDownLatch latch)
    {
            this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println("Thread in action!");
        latch.countDown();
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch=new CountDownLatch(10);
        Thread t=new Thread(new NewThread(latch));
        new CountDownLatch(10);

        System.out.println("Jas przygotowywuje sniadania");
        t.run();
        Thread.sleep(5000);
        System.out.println("Jas skonczyl przygotowywac sniadanie");


        System.out.println("Jas bierzez prysznic");
        t.run();
        Thread.sleep(3000);
        System.out.println("Jas skonczyl brac prysznic");


        System.out.println("Malgosia wykonuje poranne bieganie");
        t.run();
        Thread.sleep(6000);
        System.out.println("Malgosia skonczyla biegac");

        System.out.println("Jas sie ubiera");
        t.run();
        Thread.sleep(1000);
        System.out.println("Jas sie ubral");


        System.out.println("Malgosia bierze prysznic ");
        t.run();
        Thread.sleep(2000);
        System.out.println("Malgosia skonczyla prysznic");


        System.out.println("Jas wychodzi na zakupy");
        t.run();
        Thread.sleep(15000);
        System.out.println("Jas wrocil z zakupow");


        System.out.println("Malgosia je sniadanie");
        t.run();
        Thread.sleep(1000);
        System.out.println("Malgosia skonczyla jesc");


        System.out.println("Malgosia ubiera sie");
        t.run();
        Thread.sleep(1000);
        System.out.println("Malgosia sie ubrala");

        System.out.println("Malgosia wyszla do koleZankio");
        t.run();
        Thread.sleep(25000);
        System.out.println("Malgosia wrocvila od kolezanki");

        System.out.println("jas gra na konsoli");
        t.run();
        Thread.sleep(5000);
        System.out.println("Jas skonczyl grac na konsoli");


        try {
            latch.await();
            System.out.println("Dzien skonczony!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }









    }
}
