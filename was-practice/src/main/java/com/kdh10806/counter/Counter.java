package com.kdh10806.counter;

public class Counter implements Runnable {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

//    @Override
//    public void run() {
//        this.increment();
//        System.out.println("Value for Thread After increment : " + Thread.currentThread().getName() + " " +
//                this.getValue());
//        this.decrement();
//        System.out.println("Value for Thread After decrement : " + Thread.currentThread().getName() + " " +
//                this.getValue());
//
//    }

    //동기화 추가
    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println("Value for Thread After increment : " + Thread.currentThread().getName() + " " +
                    this.getValue());
            this.decrement();
            System.out.println("Value for Thread After decrement : " + Thread.currentThread().getName() + " " +
                    this.getValue());
        }
    }
}
