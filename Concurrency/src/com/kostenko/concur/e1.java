/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

/**
 *
 * @author Pavel
 */
public class e1 {
    public static void main(String[] args) {
        System.out.println("Program begins:");
        for (int i = 0; i<50; i++){
            new Thread(new MyTask()).start();
        }
        System.out.println("Program stops");
    }
}

class MyTask implements Runnable{
    static int counter;
    final int id = counter++;
    public void run(){
        System.out.println("Running #" + id + " - 1");
                Thread.yield();
        System.out.println("Running #" + id + " - 2");
                Thread.yield();
        System.out.println("Running #" + id + " - 3");
                Thread.yield();
        System.out.println("Running #" + id + " - 3");
    }
}
