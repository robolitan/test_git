package ua.multithreading.base.synhronized;


import java.util.concurrent.TimeUnit;

public class MainiSourceSynhronizedTest{
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();

        new Thread(()-> {
            try {
                source.printXY();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "synh").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->source.printX()).start();
        new Thread(()->source.printX()).start();
        new Thread(()->source.printX()).start();
        new Thread(()->source.printX()).start();
        new Thread(()->source.printX()).start();
        new Thread(()->source.printY()).start();
        new Thread(()->source.printY()).start();
        new Thread(()->source.printY()).start();
        new Thread(()->source.printY()).start();
    }
}

class Source {
    public void printY(){
        System.out.println("Y");
    }
    public synchronized void printX(){
        System.out.println("X");
    }
    public  synchronized void printXY() throws InterruptedException {
        while (true){
            Thread.sleep(400);
            System.out.println("XY");
        }
    }
}
