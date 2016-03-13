/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 *
 * @author Pavel
 */

class MyFibonacci3 implements Callable <Integer> {
    
    private static int taskNumb = 0;
    private int id = taskNumb++;
    private int count = 0;
    private int numb;

    MyFibonacci3(int n) {
        this.numb = n;
    }

    public Integer call() {
        Integer [] ints = new Integer [numb];
        int sum = 0;
        for (int i = 0; i < numb; i++) {
            ints[i] = next();
            sum = sum + ints[i];
        }
        return sum;
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

public class e5 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList <Future<Integer>> aL = new ArrayList <Future<Integer>>();
        for (int i = 0; i<5; i++){
            aL.add(exec.submit(new MyFibonacci3(i)));
        }
        Thread.yield();
        exec.shutdown();
        for (Future<Integer> fI: aL){
            try {
                System.out.println(fI.get());
            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(ex);
            }
        }
    }
}