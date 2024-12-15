package com.kdh10806.counter;

public class RaceCondition {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        /**
         * Value for Thread After increment : Thread-2 2
         * Value for Thread After increment : Thread-3 3
         * Value for Thread After increment : Thread-1 2
         * Value for Thread After decrement : Thread-2 2
         * Value for Thread After decrement : Thread-3 1
         * Value for Thread After decrement : Thread-1 0
         *
         * 멀티쓰레드 환경에서 하나의 객체를 공유하게 되면 race condition이 된다.
         * 상태를 유지하게 설계하면 안된다.(Thread Safe 하지 않다.)
         * -> 그래서 서블릿 객체가 싱글톤으로 관리 되는것
         */


    }
}
