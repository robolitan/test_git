package ua.multithreading.base.daemon;

import java.util.concurrent.ThreadFactory;

public class MainDaemon {
    public static void main(String[] args) throws InterruptedException {

        DaemonFabric daemonFabric = new DaemonFabric();
        for (int i = 0; i < 4; i++) {
            daemonFabric.newThread(()-> System.out.println("some task"));
        }
        System.out.println("finish");
        Thread.sleep(30000);
    }
}

class DaemonFabric implements ThreadFactory{
    private static int counterID;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, ++counterID + "-demon" );
        System.out.println("daemon № + " + counterID + " was created");
        return t;
    }
}
