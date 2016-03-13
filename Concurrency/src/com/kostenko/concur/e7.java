/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.concur;

import java.util.concurrent.*;
import static net.mindview.util.Print.printnb;

/**
 *
 * @author Pavel
 */
public class e7 {

}

class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            printnb("t[" + i + "].isDaemon() = "
                    + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

class Daemons {

    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
// Allow the daemon threads to
// finish their startup processes:
        TimeUnit.MICROSECONDS.sleep(1);
    }
}
