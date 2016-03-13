/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

import java.util.Arrays;

/**
 *
 * @author Pavel
 */

class MyFibonacci implements Runnable {
    
        
    private static int taskNumb = 0;
    private int id = taskNumb++;
    private int count = 0;
    private int numb;

    MyFibonacci(int n) {
        this.numb = n;
    }

    public void run() {
        Integer [] ints = new Integer [numb];
        for (int i = 0; i < numb; i++) {
            ints[i] = next();
        }
        System.out.println("Sequence " + id + ": " + Arrays.toString(ints));
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

public class e2 {
    public static void main(String[] args) {
        for (int i = 0; i<5; i++){
            new Thread(new MyFibonacci(i)).start();
        }
    }
}