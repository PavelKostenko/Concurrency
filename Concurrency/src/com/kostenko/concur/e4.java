/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Pavel
 */
class MyFibonacci2 implements Runnable {
    
    private static int taskNumb = 0;
    private int id = taskNumb++;
    private int count = 0;
    private int numb;

    MyFibonacci2(int n) {
        this.numb = n;
    }

    public void run() {
        for (int i = 0; i < numb; i++) {
            System.out.print(id + "_" + next() + " ");
        }
    }
    
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }
}

public class e4 {
    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i<5; i++){
//            exec.execute(new MyFibonacci2(10));
//        }
//        Thread.yield();
//        exec.shutdown();
//        
//        ExecutorService exec2 = Executors.newFixedThreadPool(2);
//        for (int i = 0; i<5; i++){
//            exec2.execute(new MyFibonacci2(10));
//        }
//        Thread.yield();
//        exec2.shutdown();
        
        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i<5; i++){
            exec3.execute(new MyFibonacci2(10));
        }
        Thread.yield();
        exec3.shutdown();
    }
}