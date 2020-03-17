package io.zipcoder;


import java.util.ArrayList;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        ArrayList<Thread> unsafeThreads = new ArrayList<Thread>();
        Thread monkey;
        for (int i = 0; i < 5; i++) {
             monkey = new Thread(unsafeCopier);
             unsafeThreads.add(monkey);
             unsafeThreads.get(i).setName("Monkey "+i);
             unsafeThreads.get(i).start();
        }

//        SafeCopier safeCopier = new SafeCopier(introduction);
//        Thread monkeya = new Thread(safeCopier);
//        Thread monkeyb = new Thread(safeCopier);
//        Thread monkeyc = new Thread(safeCopier);
//        Thread monkeyd = new Thread(safeCopier);
//        Thread monkeye = new Thread(safeCopier);
//        monkeya.start();
//        monkeyb.start();
//        monkeyc.start();
//        monkeyd.start();
//        monkeye.start();





        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.

        System.out.println(unsafeCopier.copiedText);
        System.out.println("------Unsafe Ended------");
//        System.out.println(safeCopier.copied);
//        System.out.println("------Safe Ended------");

    }
}