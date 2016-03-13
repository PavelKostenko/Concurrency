/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Pavel
 */
public class e6 {
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Provide cmd line parameters");
            return;
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int j = 0; j<Integer.parseInt(args[0]); j++){
            exec.execute(new MyTask6());
        }
        exec.shutdown();
    }
}

class MyTask6 implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    Random rand = new Random();
    public void run(){
        System.out.println("Starting task " + id + "...");
        int time = rand.nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException ex) {
            System.out.println(ex);;
        }
        System.out.println("Task " + id + " is completed during " + time);
    }
}